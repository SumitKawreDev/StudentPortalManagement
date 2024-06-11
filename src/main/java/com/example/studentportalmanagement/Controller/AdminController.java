package com.example.studentportalmanagement.Controller;

import com.example.studentportalmanagement.Model.*;
import com.example.studentportalmanagement.Repository.Do.StaffDO;
import com.example.studentportalmanagement.Service.StaffService;
import com.example.studentportalmanagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StaffService staffService;

    @GetMapping(value = "/adminStudentPage")
    public String adminLogin(Model model){
        LoginDetails loginDetails = new LoginDetails();
        model.addAttribute("loginDetails",loginDetails);
        return "adminHomePage";
    }
    @PostMapping(value = "/adminStudentPage/students")
    public String getStudentList(Model model){
        List<Student> studentList = studentService.getStudentList();
        if (null != studentList ){
            model.addAttribute("studentList", studentList);
            return "adminStudentPage";
        }else {
            model.addAttribute("errorMsg2","EmptyStudentList");
            return "adminHomePage";
        }
    }
    @PostMapping(value = "/adminHomePage/home")
    public String adminHome(Model model){
        model.addAttribute("studentList",studentService.getStudentList());
        return "adminHomePage";
    }

//    @PostMapping(value = "/adminFeePage/fee")
//    public String getFeeList(Model model){
//        List<Fee>  feeList = studentService.getFeeList();
//        if (null != feeList ){
//            model.addAttribute("feeList",feeList);
//            return "adminFeePage";
//        }else {
//            model.addAttribute("errorMsg3","EmptyFeeList");
//            return "adminHomePage";
//        }
//    }

//    @GetMapping("/feeDetails")
//    public String feeStudent(Model model){
//        Fee fee = new Fee();
//        model.addAttribute("fee",fee);
//        return "feeDetails";
//    }
//    @PostMapping("/feeDetails/{msg}")
//    public String feeStudent(@PathVariable(name = "msg") int studentId, Model model){
//        Fee response = studentService.studentFee(studentId);
//        if (null!=response) {
//            model.addAttribute("feeId", response.getFeeId());
//            model.addAttribute("fee",response);
//            return "feeDetails";
//        }else {
//            model.addAttribute("feeMsg", "Fee Details Not Found");
//            return "welcomePage";
//        }
//    }

    @GetMapping("/adminFeePage")
    public String feeStudent(Model model){
        Fee fee = new Fee();
        model.addAttribute("fee",fee);
        return "adminFeePage";
    }

    @PostMapping(value = "/adminFeePage/{studentId}")
    public String adminFee(@PathVariable("studentId")int studentId, Model model){
        List<Fee> feeList = studentService.studentFee(studentId);
        if (null!=feeList) {
            model.addAttribute("feeList",feeList);
            model.addAttribute("studentId", studentId);
            return "adminFeePage";
        }else {
            model.addAttribute("feeRerocrdMsg", "No Fee Records");
            return "adminHomePage";
        }
    }

    @GetMapping(value = "/saveFee")
    public String getFee(Model model){
        Fee fee = new Fee();
        model.addAttribute("fee",fee);
        return "saveFee";
    }

    @PostMapping(value = "/saveFee/{studentId}")
    public String saveFee(@PathVariable("studentId")int studentId, @ModelAttribute("fee")Fee fee, Model model) {
        Fee fee1 = studentService.saveFee(fee, studentId);
        if (null != fee1) {
            List<Fee> feeList = studentService.getFeeListbyStudentId(studentId);
            model.addAttribute("studentId", studentId);
            model.addAttribute("feeList", feeList);
            model.addAttribute("feeSuccesssMsg", "Saved successfull");
            return "adminFeePage";
        } else {
            model.addAttribute("feeErrorMsg", "Fee Not Save");
            return "adminFeePage";
        }
    }

    @PostMapping(value = "/addFee/{studentId}")
        public String addFee(@PathVariable("studentId")int studentId, Model model) {

            model.addAttribute("studentId",studentId);
            Fee fee = new Fee();
            model.addAttribute("fee", fee);
            return "saveFee";
        }


    @GetMapping(value = "/deleteFee")
    public String getNewFee(Model model){
//        model.addAttribute("feeList",studentService.getFeeList());
        return "adminFeePage";
    }

    /**
     * we use deleteFee method for delete or remove fee
     * @param studentId
     * @param model
     * @return feeList
     */
    @PostMapping(value = "/deleteFee/{studentId}/{feeId}")
    public String deleteFee(@PathVariable("studentId")int studentId, @PathVariable("feeId")int feeId , Model model){
        studentService.deleteFee(feeId);
        List<Fee> feeList = studentService.getFeeListbyStudentId(studentId);
        model.addAttribute("studentId", studentId);
        model.addAttribute("feeList", feeList);
        model.addAttribute("feeSuccesssMsg", "Saved successfull");
        return "adminFeePage";
    }

    /**
     * post mapping for search fee based on month_name
     * @param keyword
     * @param model
     * @return fee based on month_name
     */
    @PostMapping(value = "/feeFilter/{studentId}")
    public String feeFilter(@PathVariable("studentId")int studentId, @RequestParam(value = "feeId", defaultValue = "0",required = true) int feeId, @RequestParam(value = "keyword",required = true) String keyword, Model model){
        List<Fee> feeList = null;
        if(keyword != null && !keyword.isEmpty() && feeId != 0) {
            feeList = studentService.getFeeListByFeeIdAndMonthName(feeId, keyword);
        }else if (keyword != null && !keyword.isEmpty()) {
            feeList = studentService.getFeeListByMonthName(keyword);
        } else if (feeId != 0) {
            feeList = studentService.getFeeListByFeeId(feeId);
        }

        model.addAttribute("FilterError","Incoorect Match");
        model.addAttribute("feeList", feeList);
        model.addAttribute("studentId",studentId);
        return "adminFeePage";
    }

    @PostMapping(value = "/adminStaffPage/staff")
    public String staffList(Model model){
        List<Staff> staffList = staffService.getStaffList();
        if (staffList != null) {
            model.addAttribute("staffList", staffList);
            return "adminStaffPage";
        }else {
            model.addAttribute("staffListErrorMsg","There Is No Staff Available");
            return "adminStaffPage";
        }
    }

    @GetMapping(value = "/adminStaffSalary")
    public String getSalary(Model model){
        Salary salary = new Salary();
        model.addAttribute("salary",salary);
        return "adminStaffSalaryPage";
    }

    @PostMapping(value = "/adminStaffSalary/{staffId}")
    public String StaffSalary(@PathVariable("staffId")int staffId, Model model){
        List<Salary> salaryList = staffService.getstaffSalary(staffId);
        if(salaryList != null) {
            model.addAttribute("staffId", staffId);
            model.addAttribute("salaryList", salaryList);
            return "adminStaffSalaryPage";
        }else {
            model.addAttribute("adminStaffSalaryErrorMsg","Salary Not Found !");
            return "adminStaffSalaryPage";
        }
    }

    @GetMapping(value = "/updateStaff")
    public String staffUpdate(Model model){
        Staff staff = new Staff();
        model.addAttribute("staff", staff);
        return "updateStaffInfo";
    }

    @PostMapping(value = "/updateStaffInfo/{staffId}")
    public String updateStaffInfo(@PathVariable("staffId")int staffId,@ModelAttribute("staff") Staff staff, Model model){
        staff.setStaffId(staffId);
        Staff staffResponse = staffService.UpdateStaff(staff);
        if (staffResponse != null) {
            List<Staff> staffList = staffService.getStaffList();
            model.addAttribute("staffList", staffList);
            model.addAttribute("staffId", staffId);
            model.addAttribute("updateMsg","StaffId" );
            model.addAttribute("UpadteSuccessMsg"," Info Upadated");
        }else {
            model.addAttribute("UpadteErrorMsg","Staff Info Not Upadated");
        }
        return "adminStaffPage";
    }
    @PostMapping(value = "/updateStaffDetails/{staffId}")
    public String updateStaffDetails(@PathVariable("staffId")int staffId,Model model){
        Staff staff1 = staffService.getStaffById(staffId);
        model.addAttribute("staffId",staffId);
        model.addAttribute("staff",staff1);
        return "staffUpdatePage";
    }

    @GetMapping(value = "/saveStaffSalary")
    public String saveStaffSalary(Model model){
        Salary salary = new Salary();
        model.addAttribute("salary",salary);
        return "adminStaffSalaryPage";
    }

    @PostMapping(value = "/SaveStaffSalary/{staffId}")
    public String saveSalary(@PathVariable("staffId")int staffId,@ModelAttribute("salary")Salary salary, Model model){
        Salary salary1 = staffService.saveSalary(staffId,salary);
        if (salary1 !=null) {
            List<Salary> salaryList = staffService.getstaffSalary(staffId);
            model.addAttribute("staffId", staffId);
            model.addAttribute("salaryList", salaryList);
            model.addAttribute("salarySaveMsg","Salary Saved Successfully!");
        }else {
            model.addAttribute("salaryNotSaveMsg","Salary Not Saved!");
        }
        return "adminStaffSalaryPage";
    }

    @PostMapping(value = "/addSalary/{staffId}")
    public String addSalary(@PathVariable("staffId")int staffId,Model model){
        Salary salary = new Salary();
        model.addAttribute("salary", salary);
        model.addAttribute("staffId", staffId);
        return "saveSalaryPage";
    }

    @GetMapping(value = "/UpdateStaffSalary")
    public String updateSalary(Model model){
        Salary salary = new Salary();
        model.addAttribute("salary",salary);
        return "adminStaffSalaryPage";
    }

    /**
     * Create End Point for Data Update
     * @param staffId
     * @param salaryId
     * @param salary
     * @param model
     * @return String (in String type , we represent a thymeleaf page where data modify box is available )
     */
    @PostMapping(value = "/UpdateStaffSalary/{staffId}/{salaryId}")
    public String updateStaffSalary(@PathVariable("staffId")int staffId,@PathVariable("salaryId")int salaryId,@ModelAttribute("staff")Salary salary, Model model){
        salary.setSalaryId(salary.getSalaryId());
        Salary salary1 = staffService.updateStaffSalary(staffId,salary);
        if (salary1 != null) {
            List<Salary> salaryList = staffService.getstaffSalary(staffId);
            model.addAttribute("salary", salary);
            model.addAttribute("salaryList", salaryList);
            model.addAttribute("staffId",staffId);
            model.addAttribute("salaryUpdatedMsg","Salary Updated");
            return "adminStaffSalaryPage";
        }else {
            model.addAttribute("salaryNotUpdatedMsg","Salary Not Updated");
            return "adminStaffSalaryPage";
        }
    }

    /**
     * Create End point for data modify box
     * @param staffId
     * @param salaryId
     * @param model
     * @return String (in String type , we represent a thymeleaf page where data modify box is available )
     */
    @PostMapping(value = "/modifySalary/{staffId}/{salaryId}")
    public String modifySalary(@PathVariable("staffId")int staffId,@PathVariable("salaryId")int salaryId,Model model){
        model.addAttribute("staffId",staffId);
        Salary salary = staffService.getSalaryById(salaryId);
        model.addAttribute("salary",salary);
        model.addAttribute("salaryId",salaryId);
        return "salaryUpdatePage";
    }

    /**
     * Create Filter (Search Box ) by salaryId, manthName and salaryStatus
     * @param staffId
     * @param salaryId
     * @param monthName
     * @param salaryStatus
     * @param model
     * @return String (in String type , we represent a thymeleaf page where data modify box is available )
     */
    @PostMapping(value = "/salaryFilter/{staffId}")
    public String salaryFilter(@PathVariable("staffId")int staffId,@RequestParam(value = "salaryId",defaultValue = "0",required = true)int salaryId,@RequestParam(value = "monthName",required = true)String monthName,@RequestParam(value = "salaryStatus",required = true)String salaryStatus, Model model){
        Salary salary = null;
        if ( monthName !=null && !monthName.isEmpty() && salaryId !=0  ) {
                salary = staffService.getSalaryByIdAndMonthName(salaryId, monthName);
                List<Salary> salaryList = new ArrayList<>();
                salaryList.add(salary);
                model.addAttribute("salaryList", salaryList);
        }else if(monthName != null && !monthName.isEmpty() && staffId != 0){
            salary = staffService.getSalaryByMonthNameAndStaffId(monthName,staffId);
            List<Salary> salaryList = new ArrayList<>();
            salaryList.add(salary);
            model.addAttribute("salaryList",salaryList);
        }else if (salaryId !=0 ){
            salary = staffService.getSalaryById(salaryId);
            List<Salary> salaryList= new ArrayList<>();
            salaryList.add(salary);
            model.addAttribute("salaryList",salaryList);
        }else if (salaryStatus != null && !salaryStatus.isEmpty() && staffId != 0 ){
            List<Salary> salaryList = staffService.getSalaryBySalaryStatusAndStaffId(salaryStatus,staffId);
//            List<Salary> salaryList = new ArrayList<>();
//            salaryList.add(salary);
            model.addAttribute("salaryList",salaryList);
//            model.addAttribute("salary",salary);
        }
        model.addAttribute("staffId",staffId);
//        model.addAttribute("salary",salary);
        return "adminStaffSalaryPage";
    }
}
