package com.library.study_library_system.service;

import com.library.study_library_system.entity.Complaint;
import java.util.List;

public interface ComplaintService {

    Complaint saveComplaint(Complaint complaint);

    List<Complaint> getAllComplaints();

}