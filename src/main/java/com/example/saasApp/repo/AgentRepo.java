package com.example.saasApp.repo;

import com.example.saasApp.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepo extends JpaRepository<Agent,Long> {
}
