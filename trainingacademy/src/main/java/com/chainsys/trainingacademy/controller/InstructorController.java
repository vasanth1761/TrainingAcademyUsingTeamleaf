package com.chainsys.trainingacademy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.chainsys.trainingacademy.dao.UserDAO;
import com.chainsys.trainingacademy.model.Comments;
import com.chainsys.trainingacademy.model.Course;
import com.chainsys.trainingacademy.model.LearnerPaymentStatus;
import com.chainsys.trainingacademy.model.Questions;
import com.chainsys.trainingacademy.model.Result;
import com.chainsys.trainingacademy.model.Videos;
@Controller
public class InstructorController {
	@Autowired 
	UserDAO userdao;
    @GetMapping("/addQuestions")
    public String addQuestions()
    {
    	return"addQuestions";
    }
	@PostMapping("/add")	
	public String instructor(@RequestParam("course")String course,@RequestParam("question")String question,@RequestParam("option1")String option1,
			@RequestParam("option2")String option2,@RequestParam("option3")String option3,@RequestParam("option4")String option4,@RequestParam("correctAnswer")String correctAnswer,
			Model model)
	{ 
		Questions insertQuestion=new Questions();
	    insertQuestion.setCourse(course);
	    insertQuestion.setQuestion(question);
	    insertQuestion.setOptionA(option1);
	    insertQuestion.setOptionB(option2);
	    insertQuestion.setOptionC(option3);
	    insertQuestion.setOptionD(option4);
	    insertQuestion.setCorrectAnswer(correctAnswer);
	    String category=insertQuestion.getCourse();
	    userdao.addQuestion(insertQuestion);
	    try {
			List<Questions>viewQuestions= userdao.getQuestion(category);
			model.addAttribute("view", viewQuestions);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		return "viewQuestions";
		
	}
	@GetMapping("/addVideo")
	public String addVideo()
	{
		return"addVideos";
	}
	@PostMapping("/addVideo")
	public String video(@RequestParam("title")String title,@RequestParam("link")String link,@RequestParam("category")String category,@RequestParam("type")String moduleType,Model model)
	{   

		Videos video=new Videos();
		video.setLink(link);
		video.setTitle(title);
		video.setCategory(category);
		video.setModuleType(moduleType);
		String course=video.getCategory();
		userdao.addVideo(video);
		try {
			List<Videos> viewVideos=userdao.getVideo(video,course);
			model.addAttribute("video",viewVideos);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return "viewVideo";
		
	}
	
	@RequestMapping("/viewQuestions")
	public String questions(Model model) {
		try {
			List<Questions>viewQuestions=userdao.getAllQuestions();
			model.addAttribute("viewAllQuestions", viewQuestions);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return "Questions";
	} 
	
	@RequestMapping("/viewVideos")
	public String videos(Model model)
	{   
		try {
			List<Videos>viewVideos=userdao.getAllVideos();
			model.addAttribute("viewAllVideos", viewVideos);
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		return "videos";
		
	}
	
	@PostMapping("/alterQuestions")
	public String alter(@RequestParam("action") String action,@RequestParam("deleteId") int id,Model model)
	{   
		

		
			try {
				userdao.deleteQuestions(id);
				List<Questions>viewQuestions=userdao.getAllQuestions();
				model.addAttribute("viewAllQuestions", viewQuestions);
			} catch (ClassNotFoundException | SQLException e) {
		
				e.printStackTrace();
			}
			
			
		
		
		return "Questions";

		
	}
	@GetMapping("/updateQuestion")
	public String updateQuestion()
	{
		return"updateQuestion";
	}
	
	@PostMapping("/alterUpdateQuestions")
	public String updateQuestions(@RequestParam("Question") String question,@RequestParam("OptionA") String optionA,@RequestParam("OptionB") String optionB,@RequestParam("OptionC")String optionC,@RequestParam("OptionD")String optionD,@RequestParam("CorrectAnswer")String correctAnswer,@RequestParam("updateid") int updateId,Model model)

	{   
		Questions updateQuestions=new Questions();
		updateQuestions.setId(updateId);
		updateQuestions.setQuestion(question);
		updateQuestions.setOptionA(optionA);
		updateQuestions.setOptionC(optionC);
		updateQuestions.setOptionB(optionB);
		updateQuestions.setOptionD(optionD);
		updateQuestions.setCorrectAnswer(correctAnswer);
		try {
			userdao.updateQuestion(updateQuestions,updateId);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		List<Questions> viewQuestions;
		try {
			viewQuestions = userdao.getAllQuestions();
			model.addAttribute("viewAllQuestions", viewQuestions);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		return "Questions";
	
	}
	@GetMapping("/updateVideo")
	public String updateVideo()
	{
		return "updateVideo";
	}
	
	@PostMapping("/updateVideo")
	public String updateVideo(@RequestParam("title")String title,@RequestParam("video")String video,@RequestParam("updateId")int id,Model model )
	{   
		Videos videos=new Videos();
		videos.setId(id);
		videos.setTitle(title);
		videos.setLink(video);
		try {
			userdao.updateVideo(videos);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		List<Videos> viewVideos;
		try {
			viewVideos = userdao.getAllVideos();
			model.addAttribute("viewAllVideos", viewVideos);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	
		return "videos";
	}
	@PostMapping("/deleteVideo")
	public String deleteVideo(@RequestParam("deleteId") int deleteId,Model model)
	{  
		try {
			userdao.deleteVideo(deleteId);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		List<Videos> viewVideos;
		try {
			viewVideos = userdao.getAllVideos();
			model.addAttribute("viewAllVideos", viewVideos);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "videos";
		
	}
	
	@RequestMapping("/viewResult")
	public  String viewResult(Model model)
	{   
	    try {
			List<Result>viewResult=userdao.getAllResults();
			
			model.addAttribute("viewResult", viewResult);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "viewResult";
		
	}
	
	@RequestMapping("/viewComments")
	public String Comment(Model model)
	{
      try {
		List<Comments>viewComments=userdao.getAllComments();

		model.addAttribute("viewComments",viewComments);
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return "viewComment";
}   
	@GetMapping("addCourse")
	public String addCourse()
	{
		return "addCourse";
	}
	@PostMapping("/course")
	public String addCourse(@RequestParam("coursename")String courseName,@RequestParam("coursetype")String courseType,@RequestParam("filePart")MultipartFile courseImage,@RequestParam("amount")int amount,Model model)
	{   
		

		byte[] imageBytes = null;
        if (!courseImage.isEmpty()) 
            try {
                imageBytes = courseImage.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
       
		Course addCourse= new Course();
		addCourse.setCourseName(courseName);
		addCourse.setCourseType(courseType);
		addCourse.setCourseImage(imageBytes);
		addCourse.setAmount(amount);
	
		
		try {
			userdao.insertCourse(addCourse);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			List<Course>course=userdao.viewCourse();
			 for (Course loc : course) {
	                String image = Base64.getEncoder().encodeToString(loc.getCourseImage());
	                loc.setImage(image);
	            }
			model.addAttribute("viewCourse",course);
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "addedCourse";
		
	}
	@PostMapping("/searchQuestions") 
	public String Student(@RequestParam("searchname")String name,Model model) 
	{ 

	List<Questions> searchQuestions;
	try {
		searchQuestions = userdao.searchQuestions(name);
		model.addAttribute("viewAllQuestions", searchQuestions);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {

		e.printStackTrace();
	}

	return "Questions"; 
	} 
	@PostMapping("/searchVideos")
	public String searchVideos(@RequestParam("searchname")String name,Model model) 
	{   
		try {
			List<Videos>searchVideos =userdao.getSearchVideos(name);
			model.addAttribute("viewAllVideos", searchVideos);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return "videos";
		
	}
	
  @RequestMapping("/viewPayment")
  public void payment(Model model)
  {   
	  LearnerPaymentStatus viewPayment=new LearnerPaymentStatus();
	  userdao.viewPayment();
  }

}
