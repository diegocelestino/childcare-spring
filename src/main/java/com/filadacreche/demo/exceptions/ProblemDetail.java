package com.filadacreche.demo.exceptions;

import java.util.List;

public class ProblemDetail {
    String title;
    List<Violation> violations;

    public ProblemDetail(String title, List<Violation> violations) {
        this.title = title;
        this.violations = violations;
    }
}