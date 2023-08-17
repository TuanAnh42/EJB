package com.example.compute.service;

import com.example.compute.entity.Computer;

import java.util.List;

public interface ComputerService {
    void addComputer(Computer computer);
    void updateComputer(Computer computer);
    void deleteComputer(long computerId);
    List<Computer> getAllComputers();
}
