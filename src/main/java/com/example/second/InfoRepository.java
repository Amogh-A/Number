package com.example.second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface InfoRepository extends JpaRepository<Info,String> , InfoRepositoryCustom{
}
