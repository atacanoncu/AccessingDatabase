package DatabaseTest.DatabaseTest.Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import DatabaseTest.DatabaseTest.Entities.User;
import DatabaseTest.DatabaseTest.Repositories.UserRepository;



@Controller
public class UserController {
	private UserRepository userRepository;
	
	
	
	@Autowired
    public void setProductService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	
	
	@GetMapping(path="/text") // Reads text file from resources folder.
	 public @ResponseBody String deneme () throws  IOException{
	 
	        String fileName = "Text.txt";
	        ClassLoader classLoader = getClass().getClassLoader();
	 
	        File file = new File(classLoader.getResource(fileName).getFile());   
	         
	        //Read File Content
	        String content = new String(Files.readAllBytes(file.toPath()));
	        return content;
	    } 
	
	@GetMapping(path="/excel")
	public @ResponseBody void excel( ) {
		ReadExcel();
	}
	
	public void ReadExcel() {
		
		String ExcelFileName = "C:\\Users\\Debomac\\Desktop\\DatabaseTest\\src\\main\\resources\\Excel.xlsx";
		try { 
			FileInputStream file = new FileInputStream(new File(ExcelFileName));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter() ;
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
				System.out.print("SheetName is " + sh.getSheetName());
				System.out.println("-----------");
				
				Iterator<Row> iterator = sh.iterator();
				while(iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						//if(cell.getCellType() == CellType.STRING) {
						//	
						//}
						System.out.print(cellValue+"\t");
					}
					System.out.print("");
					
			}
			
			
			}
			
			workbook.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@GetMapping(path="/")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userRepository.findAll();
	  }
	
	@PostMapping(path="/add" , consumes = "application/json" , produces = "text/html") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestBody User	user) {
	    // @ResponseBody means the returned String is the response, not a view name
	    User n = user ;
	    userRepository.save(n);
	    return "saved";
	  }
	
	 @GetMapping(path="/user/show" , consumes = "application/json" )
	 public @ResponseBody User getProduct(@RequestBody User user) throws Exception{
		 
		 Optional<User> n = userRepository.findById(user.getUser_id());
		 //  userRepository.findById(user_id)
		 	
	     if(n.isPresent()) {
	    	return n.get();
	    	
	     }
	     else 
	    	 return new User();
	        
	    }
	 
	 
	// https://www.baeldung.com/java-microsoft-excel
	 
	 // https://github.com/javaee/metro-jax-ws#auth
	 
	 // https://docs.spring.io/spring-security/site/docs/5.0.16.RELEASE/guides/html5/helloworld-boot.html
	 
	 // https://mkyong.com/spring-boot/spring-rest-spring-security-example/
	 
	// https://dzone.com/articles/spring-boot-security-json-web-tokenjwt-hello-world
	 
	 // https://www.baeldung.com/spring-security-oauth-jwt
	 
	// ResponseBuilder response = Response.ok((Obj
	    //         ect) file);
	    
	    // response.header("Content-Disposition",
	            //    "attachment; filename=new-excel-file.xls");
	}
