package in.mohitit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mohitit.binding.PassengerInfo;
import in.mohitit.binding.TicketInfo;

@RestController
public class TicketRestController {
	
	
	@GetMapping("/ticket/{ticketId}")
	public ResponseEntity<TicketInfo> getTicket(@PathVariable("ticketId") Integer ticketId){
		
		//logic to get ticket data
		
		TicketInfo tinfo = new TicketInfo();
		tinfo.setTicketId(ticketId);
		tinfo.setPnr("789765489");
		tinfo.setTicketStatus("CONFIRMED");
		
		return new ResponseEntity<TicketInfo>(tinfo, HttpStatus.OK);
	}
	
	
	
   
	@PostMapping(
			value="/ticket",
			produces = {"application/json"},
			consumes = {"application/json"}
			)
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo request){
		
		System.out.println(request);
		
		//logic to book ticket
		
		TicketInfo tinfo = new TicketInfo();
		tinfo.setTicketId(1234);
		tinfo.setPnr("789765489");
		tinfo.setTicketStatus("CONFIRMED");
		
		return new ResponseEntity<TicketInfo>(tinfo, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/ticket")
	public ResponseEntity<String> updateTicket(@RequestBody PassengerInfo request){
		System.out.println(request);
		
		//logic to update ticket
		
		return new ResponseEntity<String>("Ticket Updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<String> deleteTicket(@PathVariable("ticketId") Integer ticketId){
		//logic to delete a ticket
		return new ResponseEntity<String>("Ticket Deleted", HttpStatus.OK);
	}
}
