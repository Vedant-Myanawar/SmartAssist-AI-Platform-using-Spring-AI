package com.example.openai.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "helpdesk_tickets")
public class HelpDeskTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String issue;

    private String status; // e.g., OPEN, IN_PROGRESS, CLOSED

    private LocalDateTime createdAt;

    private LocalDateTime eta;

    public HelpDeskTicket() {
    }

    public HelpDeskTicket(Long id, String username, String issue, String status,
                          LocalDateTime createdAt, LocalDateTime eta) {
        this.id = id;
        this.username = username;
        this.issue = issue;
        this.status = status;
        this.createdAt = createdAt;
        this.eta = eta;
    }

    // ✅ Static builder() method
    public static Builder builder() {
        return new Builder();
    }

    // ✅ Builder class
    public static class Builder {

        private Long id;
        private String username;
        private String issue;
        private String status;
        private LocalDateTime createdAt;
        private LocalDateTime eta;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder issue(String issue) {
            this.issue = issue;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder eta(LocalDateTime eta) {
            this.eta = eta;
            return this;
        }

        // ✅ THIS IS THE FIX
        public HelpDeskTicket build() {
            HelpDeskTicket ticket = new HelpDeskTicket();
            ticket.id = this.id;
            ticket.username = this.username;
            ticket.issue = this.issue;
            ticket.status = this.status;
            ticket.createdAt = this.createdAt;
            ticket.eta = this.eta;
            return ticket;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }

}
