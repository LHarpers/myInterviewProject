package com.my.interview.project.web.rest.v1;

import com.my.interview.project.core.domain.Employee;
import com.my.interview.project.core.exception.ConflictException;
import com.my.interview.project.core.exception.ForbiddenException;
import com.my.interview.project.core.exception.NotFoundException;
import com.my.interview.project.core.mappers.EmployeeMapper;
import com.my.interview.project.core.service.EmployeeServiceImpl;
import com.my.interview.project.web.resources.request.EmployeeRequestDto;
import com.my.interview.project.web.resources.request.EmployeeUpdateRequestDto;
import com.my.interview.project.web.resources.response.EmployeeResponseDto;
import com.my.interview.project.web.rest.RestControllerBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = RestControllerBase.BASE_URI + "/v1/employee")
public class EmployeeController extends RestControllerBase {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createNewEmployee(@Valid @RequestBody EmployeeRequestDto employee) throws ConflictException, ForbiddenException {

        EmployeeResponseDto employeeCreationResponse = EmployeeMapper.MAPPER.domainToResponseDto(
                                                                employeeService.createNewEmployee(
                                                                        EmployeeMapper.MAPPER.requestDtoToDomain(employee)));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeCreationResponse);
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeResponseDto>> getAllPageable(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer pageSize){
        List<Employee> employeeList = employeeService.getAllEmployeesPaginated(page, pageSize);

        return ResponseEntity.ok(employeeList.stream()
                .map(EmployeeMapper.MAPPER::domainToResponseDto)
                .collect(Collectors.toList()));
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@Valid @RequestBody EmployeeUpdateRequestDto employee) throws NotFoundException, ForbiddenException {
        return ResponseEntity.ok(
                EmployeeMapper.MAPPER.domainToResponseDto(
                        employeeService.updateEmployee(
                                EmployeeMapper.MAPPER.requestDtoToDomain(employee))));
    }
}
