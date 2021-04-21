//package ee.bcs.valiit.exercises.exceptions;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice //st kehtib kõikidele Controlleritele
//public class ErrorHandler {
//
//    //Defineerime meetodi, mis tegeleb erroritege:
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handleError(Exception e){
//        System.out.println("handle exception here");
//       // return new ResponseEntity<Object>(new ErrorResponse("Internal error", ), HttpStatus.BAD_REQUEST);
//    }
//
//}
