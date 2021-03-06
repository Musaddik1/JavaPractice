package com.example.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.model.Country;
import com.example.login.model.Login;
import com.example.login.model.Register;
import com.example.login.model.Swap;
import com.example.login.repository.CountryRepository;
import com.example.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public String register(Register register) {

		Optional<Register> optRegister = userRepository.findByEmail(register.getEmail());
		if (optRegister.isPresent()) {

			return "User already represent";
		} else {

			if (register != null) {

				userRepository.save(register);
			}
			return "Registration successfull";
		}
	}

	@Override
	public String login(Login login) {

		Optional<Register> optRegister = userRepository.findByEmail(login.getEmail());
		if (optRegister.isPresent()) {

			Register register = optRegister.get();
			if (register.getPassword().equals(login.getPassword())) {

				return "login successfull";
			} else {
				return "password doesn't match";
			}

		} else {
			return " email or password is invalid";
		}
	}

	@Override
	public List<Country> getCountry() {

		List<Country> list = countryRepository.findAll();
		if (list != null) {
			return list;
		} else {
			return new ArrayList<Country>();
		}
	}

	@Override
	public Country getCountryByName(String name) {

		
		
		
		Optional<Country> optCountry = countryRepository.findByCountryname(name);

		if (optCountry.isPresent()) {
			Country country = optCountry.get();
			return country;
		} else {
			name.toUpperCase();
			Optional<Country> opt = countryRepository.findByCountrycode(name);
			if (opt.isPresent()) {
				Country country = opt.get();
				return country;
			} else {
				return new Country();
			}
		}

	}

	@Override
	public String covertCurrency(String from, String to, double amount) {
		
				Optional<Country> opt=countryRepository.findByCountrycode(from);
				Country country=opt.isPresent()?opt.get():null;
				if(country!=null) {
			switch(country.getCountryname().toUpperCase()) {
			
			case "INDIA" :
				if(to.equalsIgnoreCase("US") || to.equalsIgnoreCase("USA")) {
					
					return String.valueOf(amount*0.01378)+" USA";
				}else if(to.equalsIgnoreCase("EURO")) {
					
					return String.valueOf(amount*0.01136)+" EURO";
				}else if(to.equalsIgnoreCase("British Pound") || to.equalsIgnoreCase("Pound")) {
					
					return String.valueOf(amount*0.00982)+" Pound";
				}else if(to.equalsIgnoreCase("Swiss Franc") || to.equalsIgnoreCase("CHF")) {
					
					return String.valueOf(amount*0.01)+" CHF";
				} else if(to.equalsIgnoreCase("Japanese Yen") || to.equalsIgnoreCase("JPY")) {
					
					return String.valueOf(amount*1.45)+" JPY";
				}else if(to.equalsIgnoreCase("polish Zloty")|| to.equalsIgnoreCase("pln")) {
					
					return String.valueOf(amount*0.05098)+" PLN";
				}else if(to.equalsIgnoreCase("Chinese Yuan")|| to.equalsIgnoreCase("CNY")) {
					
					return String.valueOf(amount*0.08910)+" CNY";
					
				}else if(to.equalsIgnoreCase("canadian dollar") || to.equalsIgnoreCase("CAD")) {
					return String.valueOf(amount*0.01739)+" CAD";
				}else if(to.equalsIgnoreCase("Afghanistan")|| to.equalsIgnoreCase("AFN") || to.equalsIgnoreCase("AFG")) {
					
					return String.valueOf(amount*1.06045)+" AFN";
				}else if(to.equalsIgnoreCase("Albanian Lek") || to.equalsIgnoreCase("All")) {
					return String.valueOf(amount*1.38950)+" ALL";
				}else if(to.equalsIgnoreCase("Algerian Dinar") || to.equalsIgnoreCase("DZD")) {
					return String.valueOf(amount*1.82284)+" DZD";
				}else if(to.equalsIgnoreCase("United Arab Emirates dirham") || to.equalsIgnoreCase("AED")) {
					 return String.valueOf(amount*0.05061)+" AED";
				}else if(to.equalsIgnoreCase("Andorran franc")|| to.equalsIgnoreCase("ADF")) {
					return String.valueOf(amount*0.07448)+" ADF";
				}else if(to.equalsIgnoreCase("Andorran peseta") || to.equalsIgnoreCase("ADP")) {
					return String.valueOf(amount*1.88931)+" ADP";
				}else if(to.equalsIgnoreCase("Angolan Kwanza") || to.equalsIgnoreCase("AOA")) {
					return String.valueOf(amount*8.91962)+" AOA";
				}else if(to.equalsIgnoreCase("Argentine Peso") || to.equalsIgnoreCase("ARS")) {
					return String.valueOf(amount*1.23013)+" ARS";
				}else if(to.equalsIgnoreCase("Armenian Dram") || to.equalsIgnoreCase("AMD")) {
					return String.valueOf(amount*7.19000)+" AMD";
				}else if(to.equalsIgnoreCase("Aruban florin")|| to.equalsIgnoreCase("AWD")) {
					return String.valueOf(amount*0.02470)+" AWD";
				}else if(to.equalsIgnoreCase("Australian dollar")|| to.equalsIgnoreCase("AUD")) {
					return String.valueOf(amount*0.01746)+" AUD";
				}else if(to.equalsIgnoreCase("Austrian Schilling*")|| to.equalsIgnoreCase("ATS")) {
					return String.valueOf(amount*0.01746)+" ATS";
				}else if(to.equalsIgnoreCase("Azerbaijan new mannat")|| to.equalsIgnoreCase("AZN")) {
					return String.valueOf(amount*0.02343)+" AZN";
				}else if(to.equalsIgnoreCase("Azerbaijan old mannat")|| to.equalsIgnoreCase("AZM")) {
					return String.valueOf(amount*117.146)+" AZM";
				}else if(to.equalsIgnoreCase("Brahamian dollar") || to.equalsIgnoreCase("BSD")) {
					return String.valueOf(amount*0.01378)+ " BSD";
				}else if(to.equalsIgnoreCase("Bahraini dinar")|| to.equalsIgnoreCase("BHD")) {
					return String.valueOf(amount*0.00515)+" BHD";
				}else if(to.equalsIgnoreCase("Bangladeshi taka") || to.equalsIgnoreCase("BDT")) {
					return String.valueOf(amount*1.14790)+" BDT";
				}else if(to.equalsIgnoreCase("Barbados dollar")|| to.equalsIgnoreCase("BBD")) {
					return String.valueOf(amount*0.02756)+" BBD";
				}else if(to.equalsIgnoreCase("Belarusian old ruble")|| to.equalsIgnoreCase("BYR")) {
					return String.valueOf(amount*357.167)+" BYR";
				}else if(to.equalsIgnoreCase("Belarusian ruble")|| to.equalsIgnoreCase("BYN")) {
					return String.valueOf(amount*0.03572)+" BYN";
				}else if(to.equalsIgnoreCase("Belgian franc*")|| to.equalsIgnoreCase("BEF")) {
					return String.valueOf(amount*0.45806)+" BEF";
				}else if(to.equalsIgnoreCase("Belize dollar")|| to.equalsIgnoreCase("BZD")) {
					return String.valueOf(amount*0.02722)+" BZD";
				}else if(to.equalsIgnoreCase("bermudian dollar")|| to.equalsIgnoreCase("BMD")) {
					return String.valueOf(amount*0.01378)+" BMD";
				}else if(to.equalsIgnoreCase("Bhutan Ngultrum")|| to.equalsIgnoreCase("BTN")) {
					return String.valueOf(amount*1.00000)+" BTN";
				}else if(to.equalsIgnoreCase("Bolivian boliviano")||to.equalsIgnoreCase("BOB")) {
					return String.valueOf(0.09301)+" BOB";
				}else if(to.equalsIgnoreCase("Bosnian Mark") || to.equalsIgnoreCase("BAM")) {
					return String.valueOf(amount*0.02222)+" BAM";
				}else if(to.equalsIgnoreCase("Botswana Pula")||to.equalsIgnoreCase("BWP")) {
					return String.valueOf(amount*0.14797)+" BWP";
				}else if(to.equalsIgnoreCase("Brazilian Real") ||to.equalsIgnoreCase("BRL")) {
					return String.valueOf(amount*0.07495)+" BRL";
				}else if(to.equalsIgnoreCase("Brunei dollar") || to.equalsIgnoreCase("BND")) {
					return String.valueOf(amount*0.01822)+" BND";
				}else if(to.equalsIgnoreCase("Bulgarian Lev") || to.equalsIgnoreCase("BGN")) {
					return String.valueOf(amount*0.02222)+" BGN";
				}else if(to.equalsIgnoreCase("Bulgarian old lev") || to.equalsIgnoreCase("BGL")) {
					
					return String.valueOf(amount*0.02222)+" BGL";
				}else if(to.equalsIgnoreCase("Burundi Franc*")|| to.equalsIgnoreCase("BIF")) {
					return String.valueOf(amount*26.5510)+" BIF";
				}
				
				else if(to.equalsIgnoreCase("Cambodian Riel")|| to.equalsIgnoreCase("KHR")) {
					
					return String.valueOf(amount*55.5139)+" KHR";
				}else if(to.equalsIgnoreCase("Canadian Dollar") || to.equalsIgnoreCase("CAD")) {
					return String.valueOf(amount*0.01734)+" CAD";
				}else if(to.equalsIgnoreCase("Cape Verde  Escudo")|| to.equalsIgnoreCase("CVE")) {
					
					return String.valueOf(amount*1.25269)+" CVE";
				}else if(to.equalsIgnoreCase("Cayman Islands dollar")||to.equalsIgnoreCase("KYD")) {
					return String.valueOf(amount*0.01151)+" KYD";
					
				}else if(to.equalsIgnoreCase("Central Pacific Franc")||to.equalsIgnoreCase("CFP")) {
					
					return String.valueOf(amount*1.35569)+" CFP";
				}
				
				else if(to.equalsIgnoreCase("CFA Franc BCEAO") || to.equalsIgnoreCase("XOF")) {
					
					return String.valueOf(amount*7.45214)+" XOF";
				}
				else if(to.equalsIgnoreCase("CFA Franc BEAC") || to.equalsIgnoreCase("XAF")) {
					
					return String.valueOf(amount*7.45214)+" XAF";
				}
				else if(to.equalsIgnoreCase("CFP Franc")|| to.equalsIgnoreCase("XPF")) {
					return String.valueOf(amount*1.35569)+" XPF";
				}
				
				else if(to.equalsIgnoreCase("Chilean Peso")|| to.equalsIgnoreCase("CLP")) {
					
					return String.valueOf(amount*9.70561)+" CLP";
				}else if(to.equalsIgnoreCase("Colombian Peso") || to.equalsIgnoreCase("COP")) {
					
					return String.valueOf(amount*49.3490)+" COP";
				}
				
				else if(to.equalsIgnoreCase("Comoras Franc")|| to.equalsIgnoreCase("KMF")) {
					
					return String.valueOf(amount*5.58910)+" KMF";
				}
				
				else if(to.equalsIgnoreCase("Congolese Franc")||to.equalsIgnoreCase("CDF")) {
					return String.valueOf(amount*27.1843)+ " CDF";
				}
				else if(to.equalsIgnoreCase("Costa Rican Colon")||to.equalsIgnoreCase("CRC")) {
					
					return String.valueOf(amount*8.28591)+" CRC";
				}
				
				else if(to.equalsIgnoreCase("Croatian Kuna")|| to.equalsIgnoreCase("HRK")) {
					
					return String.valueOf(amount*0.08602)+" HRK";
				}
				
				else if(to.equalsIgnoreCase("Cuban Convertible Peso")|| to.equalsIgnoreCase("CUC")) {
					
					return String.valueOf(amount*0.01381)+" CUC";
				}else if(to.equalsIgnoreCase("Cuban Peso")|| to.equalsIgnoreCase("CUP")) {
					
					return String.valueOf(amount*0.34518)+" CUP";
				}
				else if(to.equalsIgnoreCase("Cyprus Pound*")|| to.equalsIgnoreCase("CYP")) {
					return String.valueOf(amount*0.00665)+" CYP";
				}
				else if(to.equalsIgnoreCase("CZech Koruna")|| to.equalsIgnoreCase("CZK")) {
					
					return String.valueOf(amount*0.29468)+" CZK";
				}
				else if(to.equalsIgnoreCase("Czechoslovak Koruna*")|| to.equalsIgnoreCase("CSK")) {
					
					return String.valueOf(amount*0.29468)+" CSK";
				}
				else if(to.equalsIgnoreCase("Danish Krone")|| to.equalsIgnoreCase("DKK")) {
					
					return String.valueOf(amount*0.08448)+" DKK";
					
				}
				else if(to.equalsIgnoreCase("Djibouti Franc")|| to.equalsIgnoreCase("DJF")) {
					
					return String.valueOf(amount*2.45370)+" DJF";
				}
				else if(to.equalsIgnoreCase("Dominican R.Peso")||to.equalsIgnoreCase("DOP")) {
					
					return String.valueOf(amount*0.79338)+" KOP";
				}
				else if(to.equalsIgnoreCase("Dutch Guilder*")|| to.equalsIgnoreCase("NLG")) {
					
					return String.valueOf(amount*0.02504)+" NLG";
				}
				
				else if(to.equalsIgnoreCase("East Carribean Dollar")|| to.equalsIgnoreCase("XCD")) {
					
					return String.valueOf(amount*0.03728)+" XCD";
				}
				else if(to.equalsIgnoreCase("ECU*")|| to.equalsIgnoreCase("XEU")) {
					
					return String.valueOf(amount*0.01136)+" XEU";
				}
				else if(to.equalsIgnoreCase("Ecuador Sucre*")|| to.equalsIgnoreCase("ECS")) {
					
					return String.valueOf(amount*332.674)+" ECS";
				}
				else if(to.equalsIgnoreCase("Egyptian Pound")||to.equalsIgnoreCase("EGP")) {
					return String.valueOf(amount*0.21608)+" EGP";
				}
				else if(to.equalsIgnoreCase("EL Salvastor Colon*")|| to.equalsIgnoreCase("SVC")) {
					return String.valueOf(amount*0.12081)+" SVC";
				}
				
				else if(to.equalsIgnoreCase("Eritrean Nafta")|| to.equalsIgnoreCase("ERN")) {
					
					return String.valueOf(amount*0.20711)+" ERN";
				}
				else if(to.equalsIgnoreCase("Estonian Kroon*")|| to.equalsIgnoreCase("EEK")) {
					return String.valueOf(amount*0.17776)+" EEK";
				}
				else if(to.equalsIgnoreCase("Ethiopian Birr")|| to.equalsIgnoreCase("ETB")) {
					
					return String.valueOf(amount*0.55135)+" ETB";
				}
				else if(to.equalsIgnoreCase("Falkland Island Pound")|| to.equalsIgnoreCase("FKP")) {
					
					return String.valueOf(amount*0.00976)+" FKP";
				}
				else if(to.equalsIgnoreCase("Fiji dollar")||to.equalsIgnoreCase("FJD")) {
					return String.valueOf(amount*0.02769)+" FJD";
				}
				else if(to.equalsIgnoreCase("Finnish Markka*")|| to.equalsIgnoreCase("FIM")) {
					
					return String.valueOf(amount*0.06755)+" FIM";
				}
				
				else if(to.equalsIgnoreCase("French Franc*")|| to.equalsIgnoreCase("FRF")) {
					
					return String.valueOf(amount*0.07452)+" FRF";
				}
				
				else if(to.equalsIgnoreCase("Gambian Dalasi")|| to.equalsIgnoreCase("GMD")) {
					
					return String.valueOf(amount*0.70434)+" GMD";
				}
				else if( to.equalsIgnoreCase("Georgion lari")||to.equalsIgnoreCase("GEL")) {
					
					return String.valueOf(amount*0.04556)+" GEL";
				}
				else if(to.equalsIgnoreCase("German Mark*")|| to.equalsIgnoreCase("DEM")) {
					
					return String.valueOf(amount*0.02222)+" DEM";
				}
				else if(to.equalsIgnoreCase("Ghanaian Cedi*")|| to.equalsIgnoreCase("GHC")) {
					
					return String.valueOf(amount*792.739)+" GHC";
				}
				
				else if(to.equalsIgnoreCase("Ghanaian New Cedi")|| to.equalsIgnoreCase("GHS")) {
					return String.valueOf(amount*0.07927)+" GHS";
				}
				else if(to.equalsIgnoreCase("Gibraltar Pound")|| to.equalsIgnoreCase("GIP")) {
					
					return String.valueOf(amount*0.00976)+" GIP";
				}
				else if(to.equalsIgnoreCase("Gold (OZ)")|| to.equalsIgnoreCase("XAU")) {
					
					return String.valueOf(amount*0.00001)+" XAU";
				}
				
				else if(to.equalsIgnoreCase("Greek Drachma*")|| to.equalsIgnoreCase("GRD")) {
					
					return String.valueOf(amount*3.87116)+" GRD";
					
				}
				else if(to.equalsIgnoreCase("Gautemalan Quetzal")|| to.equalsIgnoreCase("GTQ")) {
					
					return String.valueOf(amount*0.10413)+" GTQ";
				}
				else if(to.equalsIgnoreCase("Guinea Franc")|| to.equalsIgnoreCase("GNF")) {
					
					return String.valueOf(amount*138.476)+" GNF";
				}
				else if(to.equalsIgnoreCase("Guyanese Dollar")|| to.equalsIgnoreCase("GYD")) {
					
					return String.valueOf(amount*2.77382)+" GYD";
				}
				else if(to.equalsIgnoreCase("Haitian Gourde")|| to.equalsIgnoreCase("HTG")) {
					
					return String.valueOf(amount*1.01440)+" HTG";
				}
				else if(to.equalsIgnoreCase("Honduran Lempira")|| to.equalsIgnoreCase("HNL")) {
					
					return String.valueOf(amount*0.32797)+" HNL";
				}
				
				else if(to.equalsIgnoreCase("Hong Kong Dollar")|| to.equalsIgnoreCase("KHD")) {
					
					return String.valueOf(amount*0.10707)+" KHD";
				}
				else if(to.equalsIgnoreCase("Hungarian Forint")|| to.equalsIgnoreCase("HUF")) {
					
					return String.valueOf(amount*4.08032)+" HUF";
				}
				else if(to.equalsIgnoreCase("Iceland krona") || to.equalsIgnoreCase("ISK")) {
					
					return String.valueOf(amount*1.73910)+" ISK";
				}
				else if(to.equalsIgnoreCase("Indian Rupee")|| to.equalsIgnoreCase("INR") || to.equalsIgnoreCase("India")) {
					System.out.println(String.valueOf(amount*1)+" INR");
					return String.valueOf(amount*1)+" INR";
				}
				else if(to.equalsIgnoreCase("Indonesian Rupiah")|| to.equalsIgnoreCase("IDR")) {
					
					return String.valueOf(amount*195.690)+" IDR";
				}
				else if(to.equalsIgnoreCase("Iranian rial")|| to.equalsIgnoreCase("IRR")) {
					return String.valueOf(amount*575.738)+" IRR";
				}
				else if(to.equalsIgnoreCase("Iraqi Dinar")||to.equalsIgnoreCase("IQD")) {
					
					return String.valueOf(amount*19.7567)+" IQD";
				}
				else if(to.equalsIgnoreCase("Irish Punt*")|| to.equalsIgnoreCase("IEP")) {
					return String.valueOf(amount*0.00897)+" IEP";
				}
				else if(to.equalsIgnoreCase("Israeli New Shekel")|| to.equalsIgnoreCase("ILS")) {
					
					return String.valueOf(amount*0.04528)+" ILS";
				}
				else if(to.equalsIgnoreCase("Italian Lira*")|| to.equalsIgnoreCase("ITL")) {
					return String.valueOf(amount*22.0633)+" ITL";
				}
				else if(to.equalsIgnoreCase("Jamaican Dollar")|| to.equalsIgnoreCase("JMD")) {
					
					return String.valueOf(amount*2.04576)+" JMD";
				}
				
			}
				}
		
		
		return null;
}

	@Override
	public Swap getSwap(String from, String to) {
		
		return new Swap(to, from);
	}
}
