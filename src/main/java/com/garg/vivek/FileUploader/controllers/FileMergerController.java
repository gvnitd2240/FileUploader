package com.garg.vivek.FileUploader.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merge")
@Tag(name = "File Merger", description = "Controller to merge files from provided URLs")
public class FileMergerController {


}
