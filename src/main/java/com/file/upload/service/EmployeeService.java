package com.file.upload.service;

import com.file.upload.entity.Employee;
import com.file.upload.entity.EmployeeCsvRepresentation;
import com.file.upload.repository.EmployeeRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public Integer uploadStudents(MultipartFile file) {
        Set<Employee> employees = null;
        try {
            employees = parseEmployeeCsv(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        employeeRepository.saveAll(employees);
        return employees.size();
    }

    private Set<Employee> parseEmployeeCsv(MultipartFile file) throws IOException {
        Set<Employee> employees = null;
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
            HeaderColumnNameMappingStrategy<EmployeeCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(EmployeeCsvRepresentation.class);
            CsvToBean<EmployeeCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<EmployeeCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            employees = csvToBean.parse().stream()
                    .map(csvLine -> {
                        return new Employee()
                                .setEmployeeId(Integer.parseInt(csvLine.getEmployeeId()))
                                .setName(csvLine.getName())
                                .setDepartment(csvLine.getDepartment())
                                .setRole(csvLine.getRole())
                                .setSalary(csvLine.getSalary())
                                .setCity(csvLine.getCity())
                                .setEducation(csvLine.getEducation())
                                .setJoiningDate(csvLine.getJoiningDate());

                    }).collect(Collectors.toSet());
        }
        return employees;
    }
}
