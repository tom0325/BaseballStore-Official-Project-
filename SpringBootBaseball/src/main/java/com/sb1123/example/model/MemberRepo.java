package com.sb1123.example.model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.io.Serializable;

import java.util.List;
import com.sb1123.example.model.*;

@Repository
public interface MemberRepo extends CrudRepository<Member,String>{

	//String UpdateByPhone(String phone);
	// 使用自動化命名規則進行條件搜尋
    //Member findByName(String name); // where name=?

    // 使用自動化命名規則進行條件搜尋(多條件)
    //List<Member> findByNameAndAge(String name, Integer age);
    
	/*Member findByPhone(String phone);
    Member findByName(String name);
    List<Member> findByNameAndAge(String name,String phone);
    */
}
