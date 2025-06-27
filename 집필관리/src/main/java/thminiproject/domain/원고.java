package thminiproject.domain;

import thminiproject.집필관리Application;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;


@Entity
@Table(name="원고_table")
@Data

//<<< DDD / Aggregate Root
public class 원고  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
private Long id;    
    
    
private String title;    
    
    
private String date;    
    
    
private String authorName;    
    
    
private String contents;    
    
    
private String status;    
    
    
private String type;


    public static 원고Repository repository(){
        원고Repository 원고Repository = 집필관리Application.applicationContext.getBean(원고Repository.class);
        return 원고Repository;
    }



//<<< Clean Arch / Port Method
    public void registManuscript(RegistManuscriptCommand registManuscriptCommand){
        
        //implement business logic here:
        


        ManuscriptRegisted manuscriptRegisted = new ManuscriptRegisted(this);
        manuscriptRegisted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void requestPublish(RequestPublishCommand requestPublishCommand){
        
        //implement business logic here:
        


        PublishRequested publishRequested = new PublishRequested(this);
        publishRequested.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void editManuscript(EditManuscriptCommand editManuscriptCommand){
        
        //implement business logic here:
        

        thminiproject.external.원고Query 원고Query = new thminiproject.external.원고Query();
        // 원고Query.set??()        
          = 원고Application.applicationContext
            .getBean(thminiproject.external.Service.class)
            .원고(원고Query);

        ManuscriptEdited manuscriptEdited = new ManuscriptEdited(this);
        manuscriptEdited.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void deleteManuscript(DeleteManuscriptCommand deleteManuscriptCommand){
        
        //implement business logic here:
        


        ManuscriptDeleted manuscriptDeleted = new ManuscriptDeleted(this);
        manuscriptDeleted.publishAfterCommit();
    }
//>>> Clean Arch / Port Method
//<<< Clean Arch / Port Method
    public void saveManuscript(SaveManuscriptCommand saveManuscriptCommand){
        
        //implement business logic here:
        


        ManuscriptSaved manuscriptSaved = new ManuscriptSaved(this);
        manuscriptSaved.publishAfterCommit();
    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
