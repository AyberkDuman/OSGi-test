package converterServiceTR;

//this class convert number to word for "Turkish words"

public class ConverterServiceTR {
		
	
	// kullanacag�m�z kelimeleri tan�mlar�.
	
	private static String[] singleDigit = {"s�f�r", "bir", "iki", "��", "d�rt", "be�", "alt�", "yedi", "sekiz", "dokuz"};

	private static String[] tensDigits = {"", "on", "yirmi", "otuz", "k�rk", "elli", "altm��", "yetmi�", "seksen", "doksan"};
	    
	 
	// convert isleminde kullanilacak methodlarin tan�mlar�.
	    
	private static String convertSingleDigit(int number) {
	        
		return singleDigit[number];
	        
	}
	    
	private static String convertTensDigits(int number) {
	        
		return tensDigits[number / 10];
	        
	}
	    
	private static String convertRestTwoDigits(int number) {

		return tensDigits[number / 10] + " " + singleDigit[number % 10];
	        
	}
	    
	private static String convertHundreds(int number) {
	        
		String hundredResult = singleDigit[number / 100] + " y�z";
	        
		int remaining = number % 100;

			if (remaining != 0) {
			
				hundredResult += " " + convertNumberToWords(remaining);	
			
			}
	        
	    return hundredResult;
	        
	}
	    
	private static String convertThousands(int number) {
	        
		int thousand = number / 1000;
	        
		String thousandResult = "";
	        
	 	thousandResult = convertNumberToWords(thousand) + " bin";
	                
		int remaining = number % 1000;

	        if (remaining != 0) {
	            
	            thousandResult += " " + convertNumberToWords(remaining);
	            
	        }
	        
	        return thousandResult;
	        
	    }
	    
	    private static String convertMilions(int number) {
	        
	        int million = number / 1000000;
	        
	        String millionResult = "";
	        
	        millionResult = convertNumberToWords(million) + " milyon";
	        
	        int remaining = number % 1000000;

	        if (remaining != 0) {
	            
	            millionResult += " " + convertNumberToWords(remaining);
	            
	        }
	        
	        return millionResult;
	        
	    }
	    
	    private static String convertBilions(int number) {
	        
	        int billion = number / 1000000000;
	        
	        String billionResult = "";
	        
	        billionResult = convertNumberToWords(billion) + " milyar";
	        
	        int remaining = number % 1000000000;

	        if (remaining != 0) {
	            
	            billionResult += " " + convertNumberToWords(remaining);
	            
	        }
	        
	        return billionResult;
	        
	    }
	    
	 // convert islemini yapan ana method.
	    
	    public static String convertNumberToWords(int number) {
	        
	        if (number >= 0 && number <= 9) { //0,1,...9
	            
	            return convertSingleDigit(number);
	            
	        } else if (number >= 10 && number <= 90 && number % 10 == 0) { //10,20,...90
	            
	            return convertTensDigits(number);
	            
	        }else if (number >= 11 && number <= 99) { //11,12,...99
	            
	            return convertRestTwoDigits(number);
	            
	        } else if (number >= 100 && number <= 999) { //100,101,...999
	            
	            return convertHundreds(number);
	            
	        } else if (number >= 1000 && number <= 999999) { //1000,...999999
	            
	            return convertThousands(number);
	            
	        } else if (number >= 1000000 && number <= 999999999) { //1000000,...999999999
	            
	            return convertMilions(number);
	            
	        } else if (number >= 1000000000 && number <= 2147483647) { //1000000000,...2147483647
	            
	            return convertBilions(number);
	            
	        } else if (number <= -1 && number >= -2147483648) { //minus -1,...-2147483648
	            
	            return "minus " + convertNumberToWords(Math.abs(number));
	            
	        } else {
	            
	            throw new IllegalArgumentException("TAM SAY� DE��L");
	            
	        }
	        
	    }
	    
	    

	
}
