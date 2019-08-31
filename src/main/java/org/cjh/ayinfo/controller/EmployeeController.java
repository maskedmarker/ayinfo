package org.cjh.ayinfo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.cjh.ayinfo.entity.Employee;
import org.cjh.ayinfo.model.ui.EmployeeDetailVO;
import org.cjh.ayinfo.model.ui.UIEmployeePaginationQuery;
import org.cjh.ayinfo.model.ui.UIPaginationResult;
import org.cjh.ayinfo.model.ui.UIResponse;
import org.cjh.ayinfo.service.EmployeeService;
import org.cjh.ayinfo.util.UploadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
    @Value("${pic.bas.dir}")
    private String picBaseDir;
    
    @Autowired
    private EmployeeService employeeService;
    
    @RequestMapping("/getPaginatedFuzzyList.do")
    public UIResponse<UIPaginationResult<Employee>> getPaginatedFuzzyList(@RequestBody UIEmployeePaginationQuery uiQuery) {
        List<Employee> list = employeeService.getFuzzyPageList(uiQuery);
        Integer total = employeeService.countFuzzy(uiQuery);
        UIPaginationResult<Employee> result = new UIPaginationResult<>();
        result.setTotal(total);
        result.setRows(list);
        UIResponse<UIPaginationResult<Employee>> resp = new UIResponse<>();
        resp.setData(result);
        return resp;
    }
    
    @RequestMapping("/getEmployeeDetailById.do")
    public UIResponse<EmployeeDetailVO> getEmployeeDetailById(@RequestParam(name = "employeeId") Integer employeeId) {
        UIResponse<EmployeeDetailVO> resp = new UIResponse<EmployeeDetailVO>();
        EmployeeDetailVO employee = employeeService.getEmployeeDetailById(employeeId);
        resp.setData(employee);
        return resp;
    }
    
    @RequestMapping("/addEmployeeDetail.do")
    public UIResponse<Object> addEmployeeDetail(@RequestBody EmployeeDetailVO param) {
        UIResponse<Object> resp = new UIResponse<>();
        param.setEmployeeId(null);
        EmployeeDetailVO ret = employeeService.addEmployeeDetail(param);
        resp.setData(ret);
        return resp;
    }
    
    @RequestMapping("/updateEmployeeDetail.do")
    public UIResponse<Object> updateEmployeeDetail(@RequestBody EmployeeDetailVO param) {
        UIResponse<Object> resp = new UIResponse<>();
        employeeService.updateEmployeeDetail(param);
        return resp;
    }
    
    @RequestMapping("/deleteEmployeeDetail.do")
    public UIResponse<Object> deleteEmployeeDetail(@RequestParam(name = "employeeId") Integer employeeId) {
        UIResponse<Object> resp = new UIResponse<>();
        employeeService.deletedeleteEmployeeDetail(employeeId);
        return resp;
    }
    
    @RequestMapping("/uploadPicture.do")
    public UIResponse<String> uploadPicture(@RequestParam(name = "picture") MultipartFile pictureFile) {
        UIResponse<String> resp = new UIResponse<>();
        String fileExtension = UploadUtils.getFileExtensionName(pictureFile.getOriginalFilename());
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;
        File dest = null;
        try {
            dest = new File(picBaseDir, fileName);
            pictureFile.transferTo(dest);
            resp.setData(fileName);
        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException("上传图片异常");
        }
        return resp;
    }
    
    @RequestMapping("/uploadFiles.do")
    public UIResponse<List<String>> uploadFiles(@RequestParam(name = "files") List<MultipartFile> files) {
        UIResponse<List<String>> resp = new UIResponse<>();
        List<String> fileIds = new ArrayList<>();
        if (!CollectionUtils.isEmpty(files)) {
            try {
                for (MultipartFile multipartFile : files) {
                    String fileExtension = UploadUtils.getFileExtensionName(multipartFile.getOriginalFilename());
                    String fileName = UUID.randomUUID().toString().replace("-", "") + "." + fileExtension;
                    File dest = null;
                    dest = new File(picBaseDir, fileName);
                    multipartFile.transferTo(dest);
                    fileIds.add(fileName);
                }
                
                resp.setData(fileIds);
            } catch (IllegalStateException | IOException e) {
                throw new RuntimeException("上传图片异常");
            }
        }
        return resp;
    }
}
