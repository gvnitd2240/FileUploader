package com.garg.vivek.FileUploader.services.implementations;

import com.garg.vivek.FileUploader.services.interfaces.FileMergerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileMergerServiceImpl implements FileMergerService {

    @Override
    public String mergeFiles(List<String> urls) throws IllegalArgumentException {
        return String.join(",", urls);
    }
}
