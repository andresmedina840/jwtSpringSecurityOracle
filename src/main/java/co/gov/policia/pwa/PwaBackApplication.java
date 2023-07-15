package co.gov.policia.pwa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PwaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwaBackApplication.class, args);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", new Locale("es", "CO"));
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE dd/MM/yyyy hh:mm:ss a", new Locale("es", "ES"));
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-5:00"));
		
		System.out.println("Funcionando PWA " + dateFormat.format(new Date())+ " - " + sdf.format(new Date()));
	}

}
