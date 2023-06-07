package com.midterm.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.midterm.demo.models.Cashier;
import com.midterm.demo.models.Tables;
import com.midterm.demo.repositories.CashierRepository;
import com.midterm.demo.repositories.TableRepository;

// @Configuration
// public class DumpAdminData {
    
//     private CashierRepository repository;

//     public DumpAdminData(CashierRepository repository){
//         this.repository = repository;
//     }

//     @Bean
//     public CommandLineRunner initializeDatabase() throws Exception{
//         return args -> {
//             Cashier admin = new Cashier("Pink", "Panther", "ADMIN", "Male", new Date(2014, 02, 11), "pinkpanther", "1234", null);
//             Cashier cashier = new Cashier("Oggy", "Oggy", "CASHIER", "Male", new Date(2014, 02, 11), "oggy", "1234", null) ;
//             repository.saveAll(List.of(admin,cashier));
//             System.out.println("Database initialize succesfully! - User has been saved to database.");
//         };
//     }

// }

@Component
public class DumpInitialData implements CommandLineRunner{

    @Autowired
    private CashierRepository repository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
            
        if ( repository.findAll().isEmpty() ){
            Cashier admin = new Cashier("Pink", "Panther", "ADMIN", "Male", "2001-12-24", "pinkpanther", passwordEncoder.encode(("1234")), null);
            Cashier cashier = new Cashier("Oggy", "Oggy", "CASHIER", "Male", "2001-12-24", "oggy", passwordEncoder.encode(("1234")), null) ;
            repository.saveAll(List.of(admin,cashier));
            System.out.println("Database initialize succesfully! - User has been saved to database.");
        }else{
            System.out.println("Database is initilized.");
        } 

        if (tableRepository.findAll().isEmpty()){
            Tables table1 = new Tables(true, 0, 1);
            Tables table2 = new Tables(true, 0, 2);
            Tables table3 = new Tables(true, 0, 3);
            Tables table4 = new Tables(true, 0, 4);
            Tables table5 = new Tables(true, 0, 5);
            Tables table6 = new Tables(true, 0, 6);
            Tables table7 = new Tables(true, 0, 7);
            Tables table8 = new Tables(true, 0, 8);
            Tables table9 = new Tables(true, 0, 9);
            Tables table10 = new Tables(true, 0, 10);
            Tables table11 = new Tables(true, 0, 11);
            Tables table12 = new Tables(true, 0, 12);
            tableRepository.saveAll(List.of(table1,table2,table3,table4,table5,table6,table7,table8,table9,table10,table11,table12));
            System.out.println("Table initialize succesfully! - Table has been saved to database.");
        }else{
            System.out.println("Table is initilized.");
        }
        

    }
    
}
