package com.library.study_library_system.service.impl;

import com.library.study_library_system.entity.Complaint;
import com.library.study_library_system.repository.ComplaintRepository;
import com.library.study_library_system.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }
}