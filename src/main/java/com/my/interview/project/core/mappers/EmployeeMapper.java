package com.my.interview.project.core.mappers;

import com.my.interview.project.core.domain.Employee;
import com.my.interview.project.database.mysql.entities.EmployeeDao;
import com.my.interview.project.web.resources.request.EmployeeRequestDto;
import com.my.interview.project.web.resources.request.EmployeeUpdateRequestDto;
import com.my.interview.project.web.resources.response.EmployeeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper MAPPER = Mappers.getMapper( EmployeeMapper.class );

    Employee daoToDomain(EmployeeDao dao);

    @Mapping(target = "status", constant = "Active")
    EmployeeDao domainToDao(Employee domain);

    @Mapping(target = "status", constant = "Active")
    Employee requestDtoToDomain(EmployeeRequestDto requestDto);

    Employee requestDtoToDomain(EmployeeUpdateRequestDto requestDto);

    EmployeeResponseDto domainToResponseDto(Employee domain);
}
