import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;


public class RattenFanger {

	
	private static boolean deCompExit = false;

	private static int c = 0;
	private static int w = 0;
	
	private static int originalCounter= 0;
	private static int lengthStartOriginal=0;
	private static String startStringOriginal = "";
	private static String unoZero = "";
	// validazione con last digit usando Damm checksum
	//private static Damm10ChecksumDigit damm10 = new Damm10ChecksumDigit();
	private static String checkDigits = "";
	private static String checkDigits3 = "";
	private static int dammCounter = 0;

	
	public static int powerCheck (BigInteger number) {
	int power = -1;
	int comparison = -2;
	int base = 2;
	int exp = 1;
	int comm = 0;
	
	for (base = 2;base<256; base++ ){ 
	for (comm = 0;comm<256;comm++ ){ 
	for (exp = 1;exp<256; exp++ ){ 	
	BigDecimal deCompNumber = new BigDecimal(new Integer(base).toString() +"."+new Integer(comm).toString()).pow(exp);
	comparison = number.compareTo(deCompNumber.toBigInteger());
	if (comparison == 0) {
	System.out.println(base + "." + comm + " ^ " + exp + " = " + number);
	return 1;
	} else {
	if (comparison == -1) {
	exp = 256;
	} // else continue
	
	}
	
	
	}
	}	
	}
	
	
	

	
	
	return power;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
	long startTime = System.currentTimeMillis();
	
	boolean newCode = true;
	int counter =0;
	int comp=0;
	int deComp=0;
	int bitLength =0;
	
	String String1 = "";
	String String2 = "";
	
	int lengthStart=0;
	int startOriginalCounter = 0;
	int magicnumber =0;
	int bcounter =0;
	
	
	
	//System.out.println(unPack(new BigInteger("101110000000000011100100000000010111111111",2),1));  //1110001110111111111111 *2
	
	//	System.out.println( new BigInteger("1110001110111111111111",2));
	
	BigInteger ren = new BigInteger("2097151");
//	ren = unPack(new BigInteger("11010010000100110111011010110000010110011000100011100011011001110000010100101101110",2),51);
//	ren = unPack(new BigInteger("110100000000010101111111110110100100001001101101000100110001100001010000010111111111",2),75);
//	ren = unPack(new BigInteger("10101101100010011111100100000011000100000000010101010001000011011110000000100111010",2),25);
//	ren = unPack(new BigInteger("1000011111001001110111111101001010100101010000101100101100011000100111000100111111000100",2),20);	
	
//	ren = unPack(new BigInteger("101011001011010001100000100110000100100000001101000111111101011000010101101001011100",2),30);
//	ren = unPack(new BigInteger("100110011000000110000011010100000001000000100101101010110010001111011110111001101110",2),28);	
//	ren = unPack(new BigInteger("100110000000001111011000111000110100100111101010001011100000000111010010100110100010",2),34);
//	ren = unPack(new BigInteger("1111000110010000001110001011001000100011001111000110101101100010100000000100100",2),89);
	
	//	ren = unPack(new BigInteger("1111101100100000001101010100101000011000111111011001111101110100011011100101010010100111",2),10);
	//	ren = unPack(new BigInteger("100001000001000000010000011111010100111011101010110110000001010011011000000100111100100110010001",2),5);
	System.out.println(ren);
	
	System.out.println( new BigInteger("11101100000000011101100011000011000000101000001",2));
	
	
	
	
	/*
	 * -------- START
	 * 
	 */
	
	//ren = new BigInteger("15").pow(12);
	//System.out.println(ren);
	ren = new BigInteger("1110110000000001110110001100001100000010100000111101100000000011101100011000011000000101000001",2);
	
	
	
	//	ren = new BigInteger("11101100000000011101100011000011000000101000001",2);
	BigInteger start =ren;
	//	BigInteger start = new BigInteger("100000000000000000000000000000000000000000000100000000000000000000000000000000000000000000",2);
	//	BigInteger start = new BigInteger("100000000000000000000000000000111100100001100",2);
	do {
	bcounter=0;
	ren = start;
	int bitL = ren.bitLength();
	String bitC = "";
	
	if (ren.bitLength() % 4 >0){
	bitL = bitL + (4-(ren.bitLength() % 4)) ;
	
	}
	//System.out.println(ren.toString(2));
	//System.out.println(powerCheck(ren));
	System.out.println(ren);
	System.out.println(ren.toString(2));
	System.out.println(ren.bitLength() +"|"+ ren.bitLength() % 4);
	
	ren = new BigInteger("0" + ren.toString(2),2);
	System.out.println(ren.toString(2));
	
	if (newCode) {
	
	do {
	bitC = "";
	bitL = ren.bitLength();  
	
	
	for (int e = 3;e<ren.bitLength()+3;e=e+3 ) {	
	
	
	if ((e > ren.bitLength()-1) && ((ren.bitLength() + bitC.length()) % 4 >0)) { 
	//ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()) +"0",2);
	bitC = "0"+ bitC;
	} else {
	if (ren.testBit(e)) {
	
	ren = ren.flipBit(e-3);
	ren= ren.flipBit(e-2);
	ren = ren.flipBit(e-1);
	/*
	if (e== bitL-1 && bitL>ren.bitLength()) {
	System.out.println("perde 0");
	e = ren.bitLength()-1;
	bitL = ren.bitLength();
	}
	*/
	bitC = "1" +bitC;
	//	ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e-1) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()) +"1",2);
	
	//	System.out.println(ren.toString(2));
	} else {
	//System.out.println(ren.toString(2));
	bitC = "0"+ bitC;
	//	ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e-1) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()) +"0",2);
	//	System.out.println(ren.toString(2));
	}
	ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e-1) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()),2);
	
	}	
	
	} 
	ren = new BigInteger(ren.toString(2) +bitC,2);
	//	System.out.println(ren);
	//	System.out.println(ren.toString(2));
	bcounter = bcounter +1;
	  //  }  while (powerCheck(ren) == -1);
	  }  while (bcounter <200);
	System.out.println(ren);
	System.out.println(ren.toString(2));
	System.out.println(bcounter + " | " + Integer.bitCount(bcounter));
	//System.out.println(ren.setBit(0));
	
	//	System.out.println(powerCheck(ren));
	
	
	//	ren = unPack(ren,bcounter);
	
	
	/*
	 * -------- END
	 * 
	 */
	
	} else {
	
	do {
	bitC = "";
	//	bitL = ren.bitLength();  -- NEW CHANGe
	/*
	
	
	for (int e = 0;e<(ren.bitLength() % 4); e++) {
	ren = new BigInteger(ren.toString(2) + "0",2);
	System.out.println("perde 0 ma ggiunge");
	//System.out.println(ren.toString(2));	
	}
	*/
	;
	//for (int e = ren.bitLength()-1;e>ren.bitLength()/4-1;e=e-3 ) {
	// for (int e = 3;e<ren.bitLength()+3;e=e+3 ) {	-- NEW CHANGe
	for (int e = 3;e<bitL+1;e=e+3 ) {
	if ((e > ren.bitLength()-1) ) {
	//if ((e > ren.bitLength()-1) && ((ren.bitLength() + bitC.length()) % 4 >0)) { - NEW CHANGe
	//ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()) +"0",2);
	
	System.out.println(ren.bitLength());
	if ((e > ren.bitLength() +bitC.length()) ) { 
	bitC = "0"+ bitC;
	}
	} else {
	if (ren.testBit(e)) {
	/*
	ren = ren.flipBit(e-19);
	ren = ren.flipBit(e-18);
	ren = ren.flipBit(e-17);
	ren = ren.flipBit(e-16);
	ren = ren.flipBit(e-15);
	ren = ren.flipBit(e-14);
	ren = ren.flipBit(e-13);
	ren = ren.flipBit(e-12);
	ren = ren.flipBit(e-11);
	ren = ren.flipBit(e-10);
	ren = ren.flipBit(e-9);
	ren = ren.flipBit(e-8);
	ren = ren.flipBit(e-7);
	ren = ren.flipBit(e-6);
	ren = ren.flipBit(e-5);
	ren = ren.flipBit(e-4);
	*/	
	ren = ren.flipBit(e-3);
	ren= ren.flipBit(e-2);
	ren = ren.flipBit(e-1);
	/*
	if (e== bitL-1 && bitL>ren.bitLength()) {
	System.out.println("perde 0");
	e = ren.bitLength()-1;
	bitL = ren.bitLength();
	}
	*/
	bitC = "1" +bitC;
	//	ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e-1) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()) +"1",2);
	
	//	System.out.println(ren.toString(2));
	} else {
	//System.out.println(ren.toString(2));
	bitC = "0"+ bitC;
	//	ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e-1) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()) +"0",2);
	//	System.out.println(ren.toString(2));
	}
	ren = new BigInteger(ren.toString(2).substring(0, ren.bitLength()-e-1) + ren.toString(2).substring(ren.bitLength()-e, ren.bitLength()),2);
	
	}	
	
	} 
	ren = new BigInteger(ren.toString(2) +bitC,2);
	System.out.println(ren);
	System.out.println(ren.toString(2));
	bcounter = bcounter +1;
	//	}  while (powerCheck(ren) > -2);
	    }  while (powerCheck(ren) == -1);
	
	System.out.println(bcounter + " | " + Integer.bitCount(bcounter));
	//System.out.println(ren.setBit(0));
	
	System.out.println(powerCheck(ren));
	
	/*
	 * -------- END
	 * 
	 */
	
	}
	if (ren.compareTo(new BigInteger("119"))==0) {
	  System.out.println("eccolo");
	  } else {
	  start = start.add(new BigInteger("1"));
	  }
	} while (start.bitLength()<48); 
	/*
	do {
	if (ren.compareTo(new BigInteger("959409")) == 1) {
	magicnumber = 8;
	} else {
	magicnumber =8;
	
	}
	System.out.println(ren);
	
	for (double e = 2.55;e>0.0;e=e-0.01 ) {
	System.out.println(comp(ren.intValue(), new BigDecimal(e)) + " | " + e);
	System.out.println(deComp(5110000, new BigDecimal(2.53)) + " | " + e);
	}
	
	
	comp = deComp(ren.intValue(), new BigDecimal(magicnumber));
	//	comp = deComp(deComp(ren.intValue(), new BigDecimal(8.9)),new BigDecimal(1.6));
	bitLength = new BigInteger(new Integer(comp).toString()).bitLength();
	
	String1 = ren+"";
	System.out.println(comp + " bitlength:" + bitLength);
	String2 = comp(comp, new BigDecimal(magicnumber)) +"";
	//	String2 = comp(comp(comp, new BigDecimal(1.6)),new BigDecimal(8.9)) +"";
	System.out.println (String2);
	
	if (String1.equals(String2)){
	
	} else {
	System.out.println(String1+" != " +String2);
	}
	
	
	ren = ren.subtract(new BigInteger("1"));
	} while (ren.compareTo(new BigInteger("524288")) == 1);
	
	//} while (ren.compareTo(new BigInteger("1048575")) == 1);
	
	
	
	
	// altre variabili
	Boolean blnZero = false;
	
	String compBinary = "";
	String text3 = "";
	//	String test = new String("Buongiorno, mi chiamo Fede. Tu chi sei???");
	//	String test = new String("Buenas");
	//	String test = new String("Buenasn");
	String test = new String("Buenasn");
	
	
	//	String startString="";
	
	
	String binary = new BigInteger(test.getBytes()).toString(2);
	startStringOriginal = binary;
	lengthStartOriginal = startStringOriginal.length();
	
	System.out.println(binary);
	System.out.println(binary.length());
	System.out.println(new BigInteger(binary, 2).toString());
	System.out.println(new BigInteger(test.getBytes()).toString());
	System.out.println(new BigInteger(test.getBytes()).toString(2));
	
	*/
	
	/* test checkSum 
        int checksum = generateChecksum(test);
        // Call the method to create the checksum
        System.out.println("The checksum generated is = "
                + Integer.toHexString(checksum));
        
        //System.out.println("Enter the checksum to be sent:");
        //checksum = Integer.parseInt((scan.next()), 16);
        // User inputs data as hexadecimal value but it will be stored as a
        // decimal value unless it is converted into hexadecimal first.
        receive(test, checksum);
        System.out.println(new BigInteger(Integer.toHexString(checksum).getBytes()).toString(2).length());
	*/
	/*	
	//	System.out.println(new BigInteger("32136139117111123227162777887161613117231216317216116217481121274161127917616111726146861171612113286221161618222372612161313737867217612171113262672691262762311331417621812136127").toString(2).length());
	//	System.out.println(new BigInteger("321361391171111").toString(2).length());
	
	
	//	String testere = deCompStringNew("11100110100001000100","621313",""); //tret - 1953654132
	
	//	String testere = deCompStringNew("101000010100110011110","32136",""); //Buon - 1114992494
	//	String testere = deCompStringNew("100100101111010111001","321361391171111",""); //Buonos 
	//	String testere = deCompStringNew("100100101111010111001","321566321071111",""); //Buonos 
	//	String testere = deCompStringNew("100100101111010111001","321566321071111",""); //Buonos 
	//	String testere = deCompStringNew("101100011101111001100","161121116",""); //buon - 1114992494
	//	String testere = deCompStringNew("100001101111110001000","161867",""); //crop - 1668444016
	//	String testere = deCompStringNew("101000010101101100000","1618683118",""); //cropp - 1668444016
    	String testere = deCompStringNew("11101011001010101011","32136139117111123227162777887161613117231216317216116217481121274161127917616111726146861171612113286221161618222372612161313737867217612171113262672691262762311331417621812136127",""); //Buongiorno, mi chiamo Federico. Tu chi sei??? - 609692035378165904074211413611347036349462058371140323866781115207336100178630947221208026091963435244797759
    	

	//String inputStart = "321361391171111" ;
	String inputStart = "32136139117111123227162777887161613117231216317216116217481121274161127917616111726146861171612113286221161618222372612161313737867217612171113262672691262762311331417621812136127" ;
	
	
	testere ="";
	//while (testere =="" && inputStart!=inputFinal) {
	while (inputStart.equals(inputStart)) {
	testere = deCompStringBlnNew("11101011001010101011","316317113212787663121137116141224617166176481762126211122762633387162713662922631347282317","",-1,""); //Buonos
	
	//testere = deCompStringBlnNew("100100101111010111001","31631711","",-1,""); //Buonos
	if (testere !="") {
	System.out.println(inputStart + " | " +testere);
	}
	//inputStart = Integer.toBinaryString(new BigInteger(inputStart, 2).intValue() + 1);
	if (inputStart.equals("111111111111111111111")) { 
	System.out.println("test");
	
	}
	}	
	
	System.out.println(testere);

	String inputFinal = "111111111111111111111" ;
	testere ="";
	
	//while (testere =="" && inputStart!=inputFinal) {
	while (inputStart.equals(inputFinal)==false) {
	
	testere = deCompStringBln(inputStart,"32136139117111123227162777887161613117231216317216116217481121274161127917616111726146861171612113286221161618222372612161313737867217612171113262672691262762311331417621812136127",""); //cropp - 1668444016
	if (testere !="") {
	System.out.println(inputStart + " | " +testere);
	}
	inputStart = Integer.toBinaryString(new BigInteger(inputStart, 2).intValue() + 1);
	if (inputStart.equals("111111111111111111111")) { 
	System.out.println("test");
	
	}
	}	
	
	System.out.println(testere);
	System.out.println(testere.length());
 	System.out.println("unoZero: " +unoZero);
	//	testere = deCompStringNEWNEW("100001101111110001000",6,1,"", "", lengthStartOriginal); //crop - 1668444016
	//	testere = deCompStringNEWNEW("101000010101101100000",10,1,"", "", lengthStartOriginal); //cropp - 1668444016
	//	binary = testere;
	
	System.out.println("As binary: "+binary + " | BitLength: " + lengthStartOriginal);
	
	//	binary = binary + binary.substring(binary.length()-1, binary.length());
	//	System.out.println("As binary: "+binary);
	//	startString = binary; 
	
	//	lengthStart = startString.length();
	//	System.out.println("length Start:" + lengthStart);
	//	String text2 = new String(new BigInteger(binary, 2).toByteArray());
	//	System.out.println("As text: "+text2);
	 * 
	 * 
	 */
	
	/*
	int i = 20;
	int l=0;
	String number = "";
	do { 
	
	text3 = binary.substring(0,i); 
	System.out.println("As text: " + text3);
	
	int n= new BigInteger(text3, 2).intValue();
	
	System.out.println(n);
	
	//aggiungi numero a variabile per check digits 
	checkDigits = checkDigits.concat(new Integer(n).toString());
	//System.out.println("Check Digits: " + checkDigits);
	
	//aggiungi numero a variabile per check digits 3
	checkDigits3 = checkDigits3.concat(new Integer(n).toString());
	double c = 4.5;
	System.out.println (n);
	
	
	//comp = comp(n, new BigDecimal(c));
	comp = deComp(n, new BigDecimal(c));
	
	bitLength = new BigInteger(new Integer(comp).toString()).bitLength();
	System.out.println(comp + " bitlength:" + bitLength);
	System.out.println (comp(comp, new BigDecimal(c)));
	int ncomp =comp;
	boolean keepon=true;
	*/
	/*
	do  {
	
	
	
	//ncomp = comp(ncomp,new BigDecimal(c));
	ncomp = deComp(ncomp,new BigDecimal(c));
	bitLength = new BigInteger(new Integer(ncomp).toString()).bitLength();
	
	comp = ncomp;
	
	System.out.println(comp + " bitlength:" + bitLength );
	
	System.out.println (comp(comp, new BigDecimal(c)));
	
	
	} while (bitLength>16);
*/
	
	counter = counter +1;
	
	/*
	int uz = new Integer(unoZero.substring(unoZero.length()-counter,unoZero.length()-counter+1));
	if (uz == 1) {
	System.out.println(comp + " vs " + comp(n+1));
	if ((comp(n+1)-comp)== 2) {
	comp = comp + 1;
	}	else {
	comp = comp-1;
	}
	}
	
	*/
	/*work in progress
	// aggiungi checkSum digit ogni 3 iterazioni
	if (counter % 3 == 0) {
	comp = Integer.parseInt(new Integer(comp).toString() + damm10.calculateCheckSumDigit(checkDigits3));
	
	//resetta check digits 3
	checkDigits3 = "";
	}
	
	
	System.out.println(comp);
	compBinary = Integer.toBinaryString(comp);
	int compLength = compBinary.length() ;
	
	System.out.println(compBinary + " length:" + compLength);
	
	//aggiungi numero a variabile per check digits 
	checkDigits = checkDigits.concat(new Integer(comp).toString());
	System.out.println("Check Digits: " + checkDigits);
	
	//aggiungi numero a variabile per check digits 3
	checkDigits3 = checkDigits3.concat(new Integer(comp).toString());
	
	// da capire questo ma credo che sia la stringa di numeri usati per tracciare le iterazioni
	if (compLength == 21) {
	blnZero = true;

	} else {
	
	if (blnZero) {
	
	/*
	if (compLength == 16) {
	number = number.concat("0") ;
	} else {
	number = number.concat(new Integer(5+ 21 - compLength).toString()) ;
	}
	
	
	//number = number.concat(new Integer(5+ 21 - compLength).toString()) ;
	
	
	
	blnZero = false;
	} else {
	number = number.concat(new Integer( 21 - compLength).toString()) ;
	}
	}
	
	
	//	System.out.println(compBinary + "| " + number);
	
	
	
	/*
	if (counter % 2 == 0) {
	
	//	System.out.println(startString.hashCode() + " || " + Integer.toBinaryString(startString.hashCode()).length());
	//	System.out.println(compBinary.hashCode() + " || " +Integer.toBinaryString(compBinary.hashCode()).length());
	
	//	binary = compBinary + compBinary.substring(compBinary.length()-1, compBinary.length()) + binary.substring(i,binary.length()); //qui va il nuovo codice
	
	if (l<lengthStartOriginal){	
	binary = compBinary + startStringOriginal.substring(l, l+1) + binary.substring(i,binary.length()); 
	l=l+1;
	} else {
	if (l==lengthStartOriginal) {
	startOriginalCounter = counter-1;
	l= l+1;
	}
	binary = compBinary + binary.substring(i,binary.length());
	}
	} else {
	*/
	/*
	binary = compBinary.concat(binary.substring(i,binary.length()));
	//	}	
	//System.out.println("As binary: "+binary + " || Counter: " + counter);
	
	//	if (compLength<21 ) {
	//	  i= i+(21-compLength) ;
	
	//	}
	//	} while (i<binary.length() || i==binary.length());
	} while (i<binary.length());
	// compressione finita
	// stampo number - da confermare: probabilmente numero di bits tolti ad ogni iteration raddoppiando valore se c'e' iterazione neutra/0 compression
	// ignora, non credo useremo number 
	System.out.println(number);
	System.out.println(new BigInteger(number).bitLength());
	System.out.println(number.length());
	
	/*
	System.out.println(new BigInteger("1048576").bitLength());
	
	System.out.println(comp(comp(2097151)));
	System.out.println(new BigInteger("967426").toString(2));
	System.out.println(new BigInteger("967426").bitLength());
	
	System.out.println(comp(comp(1048576)));
	System.out.println(new BigInteger("1951").toString(2));
	System.out.println(new BigInteger("1951").bitLength());
	
	System.out.println(deComp(deComp(1951)));
	
	System.out.println(comp(comp(255)));
	System.out.println(new BigInteger("255").toString(2));
	System.out.println(new BigInteger("255").bitLength());
	
	
	boolean keepon = true;
	int frate =34165;
	//frate = comp(135766);
	
	do  {
	
	frate = deComp(frate, new BigDecimal(1.6));
	if (new BigInteger(new Integer(frate).toString()).bitLength() <22) {
	System.out.println(frate + " bitlength:" + new BigInteger(new Integer(frate).toString()).bitLength());
	} else {
	keepon= false;
	}
	} while(keepon);
	
	
	System.out.println(checkDigits);
	//System.out.println( new BigInteger(binary, 2).intValue());
	
	String checksum = new Integer(counter).toString();
	checksum = checksum + damm10.calculateCheckSumDigit(checkDigits);
	checksum = checksum + damm10.calculateCheckSumDigit(checkDigits.substring(1, checkDigits.length())+ checkDigits.charAt(0));
	checksum = checksum + damm10.calculateCheckSumDigit(checkDigits.substring(2, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1));
	checksum = checksum + damm10.calculateCheckSumDigit(checkDigits.substring(3, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1)+ checkDigits.charAt(2));
	checksum = checksum + damm10.calculateCheckSumDigit(checkDigits.substring(4, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1)+ checkDigits.charAt(2)+ checkDigits.charAt(3));
	checksum = checksum + damm10.calculateCheckSumDigit(checkDigits.substring(1, checkDigits.length()/2));
	System.out.println(checksum);
	String finalNumber = new BigInteger(binary, 2).toString() + checksum;
	//System.out.println(finalNumber);
	System.out.println("Compressed number: " + finalNumber + " | bithLength: " + new BigInteger(finalNumber).bitLength());
	
	
	/*
	int damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits);
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	System.out.println(checkDigits.substring(1, checkDigits.length())+ checkDigits.charAt(0)  );
	
	damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits.substring(1, checkDigits.length())+ checkDigits.charAt(0));
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	
	damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits.substring(2, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1));
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	
	damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits.substring(3, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1) + checkDigits.charAt(2)+ checkDigits.charAt(3));
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	
	damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits.substring(4, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1) + checkDigits.charAt(2)+ checkDigits.charAt(3)+ checkDigits.charAt(4));
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	
	damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits.substring(5, checkDigits.length())+ checkDigits.charAt(0) + checkDigits.charAt(1) + checkDigits.charAt(2)+ checkDigits.charAt(3)+ checkDigits.charAt(4)+ checkDigits.charAt(5));
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	
	damm10CheckSum = damm10.calculateCheckSumDigit(checkDigits.substring(1, checkDigits.length()/2));
	System.out.println("DAMM Checksum Digit is: " + damm10CheckSum);
	
	// binary e' il nostro risultato finale con anche il counter di iterazioni 
	System.out.println("binary: " + binary + " | counter:" + counter);
	
	
	// lunghezza della stringa originale
	System.out.println("BitOriginalLength: " + lengthStartOriginal);
	//ricalcola binary numbero compresso
	
	System.out.println(binary);
	System.out.println(new BigInteger(binary, 2).toString());
	System.out.println(finalNumber.substring(0,finalNumber.length()-8));
	binary = new BigInteger(finalNumber.substring(0,finalNumber.length()-8)).toString(2);
	text3 = binary;
	int end= 5-(21-binary.length());  // serve per coprire tutti i vari scenari e nel caso in cui l'ultima iterazione abbia rimosso due o piu bits
	
	// non credo che serva
	originalCounter = counter;
	
	//imposta il counter dal numero compresso
	counter = Integer.parseInt(finalNumber.substring(finalNumber.length()-8,finalNumber.length()-6));
	
	
	// prende binary e comincia a decomprimerlo partendo dallo scenario piu semplice ovvero che l'ultima compressione di iterazione arrivi a 21 bits esatti 
	
	for (i = 0;i<end;i++ ){ //2^20
	// crea variabile per parcheggiare bits che avanzano - primo scenario assume che tutta la stringa compressa sia di 21 bits e quindi non ci sono bits che avanzano
	String other = binary.substring(binary.length()-i,binary.length());
	
	System.out.println(binary.substring(0, binary.length()-i));
	
	// da capire questo e soprattutto la parte di substring che non ha senos
	//String newCheckSum = startStringOriginal.substring(l, lengthStartOriginal);
	String newCheckSum= finalNumber.substring(finalNumber.length()-6,finalNumber.length());
	
	// da capire perche il counter deve essere pari?
	/* tolto il 21/04
	if (i>0 && (counter)%2==0 )  {
	
	
	newCheckSum = other.substring(0,1) +  newCheckSum;
	other = other.substring(1,other.length());
	
	
	}
	
	*/	
	
	/*
	//text 3 e' la stringa da decomprimere, la funzione deCompString riceve la string da decomprimere, il checksum, numero di iterazioni totale fatto per la compressione e bits di coda che avanzano
	//text3 = deCompString(binary.substring(0, binary.length()-i), startString, counter, other);
	text3 = deCompString(binary.substring(0, binary.length()-i), newCheckSum, counter, other, "" );
	
	
	//text3 = deCompString(text3.substring(0, text3.length()-i), Integer.toBinaryString(1088859), counter) + text3.substring(text3.length()-i,text3.length());
	
	// se deCompExit e' true viene forzata l'uscita dal loop
	if (deCompExit) {
	i=5;
	} 
	
	}
	
	deCompExit= false;
	if (deCompExit) {
	//System.out.println(new BigInteger(text3, 2));
	System.out.println(text3);
	//System.out.println(startString);
	//if (text3.equals(startString)) {
	
	System.out.println(startStringOriginal);
	if (text3.equals(startStringOriginal)) {
	
	System.out.println("YES, IT IS EXACTLY THE SAME: WELL DONE!!!");
	}
	
	} else {
	System.out.println("NOT FOUND");
	}
	
	
	for (i = 2097152;i<2097152;i++ ){ //2^20
	//for (int i = 1048576;i<2097152;i++ ){ //2^20
	
	
	//for (int i = 1048683;i<2097152;i++ ){ //2^20
	//	for (int i = 1443675;i<2097152;i++ ){ //2^20	
	
	//launch compression
	comp = comp(i, new BigDecimal(1.6));
	
	// launch deCompression
	deComp = deComp(comp, new BigDecimal(1.6));
	
	
	
	
	if (i != deComp) {
	
	System.out.println("ISSUE -- Startnumber: " + i );
	
	System.out.println("Comp: " + comp + " | Bitlength: " + new BigInteger(Integer.toString(comp)).bitLength());
	
	System.out.println("deComp: " + deComp + " | Bitlength: " + new BigInteger(Integer.toString(deComp)).bitLength());
	
	i=2097152;
	} else {
	System.out.println("SUCCESSFUL -- Startnumber: " + i + " ("+ new BigInteger(Integer.toString(i)).bitLength() + ") | Comp: " + comp + " ("+ new BigInteger(Integer.toString(comp)).bitLength() + ")  | deComp: " + deComp + " ("+ new BigInteger(Integer.toString(deComp)).bitLength() + ")");
	
	
	
	}
	
	}
	
	
	
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	
	System.out.println("total time: " + totalTime);
	
	System.out.println("iterations: " + c);
	
	}
	
	public static BigInteger unPack(BigInteger r, int counter) {
	BigInteger ren = r;
	BigInteger a;	
	BigInteger b;	
	BigInteger c;	
	
	//	System.out.println(r.toString(2));
	/*
	if (counter == 9 ) {
	if (r.compareTo(new BigInteger("11111100011111001110111100000011110101011110001011110110000110000110100100110111110010101111",2)) ==0 ) {
	System.out.println(r.toString(2));
	}
	}
	
	*/
	/*
	if (counter == 0) {
	//	System.out.println(r.toString(2));
	a = new BigInteger(ren.toString(2).substring(0, ren.bitLength()/2),2);
	//	System.out.println(a.toString(2));
	b = new BigInteger(ren.toString(2).substring(ren.bitLength()/2,ren.bitLength()),2);
	//	System.out.println(b.toString(2));
	if (a.compareTo(b) ==0 ) {
	return a;
	} else {
	return new BigInteger("-2");
	}
	
	}	
	
	int bitL= ren.bitLength();
	
	if (ren.bitLength() % 4 >0){
	bitL = bitL + (4-(ren.bitLength() % 4)) ;
	
	}
	int start= bitL/4; //minimum number of blocks
	int i=start;
	
	do {
	bitL=bitL + (i-start)*4;

	
	a= new BigInteger(ren.toString(2).substring(0, ren.bitLength()-i),2);
	//	System.out.println(a.toString(2));
	b= new BigInteger("1"+ ren.toString(2).substring(ren.bitLength()-i,ren.bitLength() ),2);
	String sb = b.toString(2);
	//	System.out.println(b.toString(2));
	 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
	if ((bitL-ren.bitLength()==3) && (b.testBit(b.bitLength()-2) == false )) {
	//	System.out.println ("discard");
	return new BigInteger("-1");
	}
	int diff = (b.bitLength()-1)*3 - a.bitLength();
	String zero= "";
	if ((b.bitLength()-1)*3 > a.bitLength()) {
	for (int z=0; z < diff; z++) {
	zero = "0"+zero;
	}
	
	}
	a=new BigInteger("1"+zero + a.toString(2),2);
	String sa = a.toString(2);
	//	System.out.println(a.toString(2));
	
	for (int e = 0;e<b.bitLength()-1;e++ ) {
	if (b.testBit(e)) { // e==1
	a = new BigInteger(a.toString(2).substring(0, a.bitLength()-4*e-3) + "1" + a.toString(2).substring(a.bitLength()-4*e-3, a.bitLength()),2);
	
	//	System.out.println(a.toString(2));
	a = a.flipBit(4*e);
	//	System.out.println(a.toString(2));
	a = a.flipBit(4*e +1);
	//	System.out.println(a.toString(2));
	a = a.flipBit(4*e +2);
	//	System.out.println(a.toString(2));
	
	//	System.out.println(a.toString(2));
	
	} else { //e==0
	
	a = new BigInteger(a.toString(2).substring(0, a.bitLength()-4*e-3) + "0" + a.toString(2).substring(a.bitLength()-4*e-3, a.bitLength()),2);
	
	//	System.out.println(a.toString(2));
	}
	}
	i= i +1;
	a = new BigInteger(a.toString(2).substring(1,a.bitLength()),2);
	//	System.out.println(a.toString(2));
	
	c=unPack(a,counter -1);
	
	
	
	if (c.compareTo(new BigInteger("-1"))==1) {
	//	System.out.println("-1");
	return c;
	} 
	if (i>24) {
	
	//	System.out.println(i);
	//	System.out.println(i);
	return (new BigInteger ("-2"));
	}
	
	} while (r.testBit(i-1)); 	
	
	return c;
	}
	
	public static String deCompStringBln (String text, String checkSum, String textOther) {
	if (checkSum.length()==0) {
	return text + textOther;
	}
	boolean bln21 = false;
	int deComp=0;
	String deCompBinary = text;
	int number = new Integer(checkSum.substring(checkSum.length()-1,checkSum.length()));
	if (number == 0){ 
	bln21=true;
	number = 5;
	} else {
	if (number >5) {
	bln21=true;
	number = number -5;
	}
	}
	String newCheckSum = checkSum.substring(0,checkSum.length()-1);
	String other = deCompBinary.substring(deCompBinary.length()-number +21-deCompBinary.length() ,deCompBinary.length()) ;	//in the case the 
	String text3= deCompBinary.substring(0, deCompBinary.length()-number +21-deCompBinary.length());
	
	String newTextOther = new StringBuilder(other).append(textOther).toString();
	

	int n = new BigInteger(text3, 2).intValue();
	
	
	deComp = deComp(n, new BigDecimal(1.6));
	
	if (n != comp(deComp, new BigDecimal(1.6))) {
	
	return "";
	//	System.out.println("deComp " + deComp + ": "  + comp(deComp) + " vs " + n);
	
	}
	
	
	deCompBinary = Integer.toBinaryString(deComp);
	//	System.out.println("As text: " + deCompBinary);
	//	System.out.println(deComp);
	
	if (bln21 ) {
	n = new BigInteger(deCompBinary, 2).intValue();
	
	deComp = deComp(n,new BigDecimal(1.6));
	if (n != comp(deComp, new BigDecimal(1.6))) {
	
	return "";
	//	System.out.println("deComp: " + comp(deComp) + " vs " + n);
	}
	deCompBinary = Integer.toBinaryString(deComp);
	//	System.out.println("As text: " + deCompBinary);
	//	System.out.println(deComp);
	
	}
	
	text = deCompStringBln(deCompBinary,newCheckSum, newTextOther);
	return text;
	}
	
	public static String deCompStringBlnNew (String text, String checkSum, String textOther, int c, String code) {
	
	boolean blnIterate = true;
	int number2 = 0;
	if (checkSum.length()==0) {
	code = code.substring(1,code.length());
	System.out.println(code);
	return text + textOther;
	
	
	}
	boolean bln21 = false;
	int deComp=0;
	String deCompBinary = text;
	int number = new Integer(checkSum.substring(checkSum.length()-1,checkSum.length()));
	number2=number;
	if (number == 0){ 
	bln21=true;
	number = 5;
	} else {
	if (number >5) {
	bln21=true;
	number = number -5;
	}
	}
	
	if (number2 == 7) {
	
	number2 = 7;
	}
	String newCheckSum = "";
	
	
	String other = deCompBinary.substring(deCompBinary.length()-number +21-deCompBinary.length() ,deCompBinary.length()) ;	//in the case the 
	String text3= deCompBinary.substring(0, deCompBinary.length()-number +21-deCompBinary.length());
	
	String newTextOther = new StringBuilder(other).append(textOther).toString();
	

	int n = new BigInteger(text3, 2).intValue();
	
	
	deComp = deComp(n, new BigDecimal(1.6));
	
	if (n != comp(deComp, new BigDecimal(1.6))) {
	
	return "";
	//	System.out.println("deComp " + deComp + ": "  + comp(deComp) + " vs " + n);
	
	}
	
	
	deCompBinary = Integer.toBinaryString(deComp);
	//	System.out.println("As text: " + deCompBinary);
	//	System.out.println(deComp);
	
	if (bln21 ) {
	n = new BigInteger(deCompBinary, 2).intValue();
	
	deComp = deComp(n, new BigDecimal(1.6));
	if (n != comp(deComp, new BigDecimal(1.6))) {
	
	return "";
	//	System.out.println("deComp: " + comp(deComp) + " vs " + n);
	}
	deCompBinary = Integer.toBinaryString(deComp);
	//	System.out.println("As text: " + deCompBinary);
	//	System.out.println(deComp);
	
	}
	if (c==-1) {
	
	blnIterate = true;
	
	c= c+1;
	newCheckSum =  checkSum.substring(0,checkSum.length()-1) + c;
	} else {
	blnIterate = false;
	c=-1;
	newCheckSum =  checkSum.substring(0,checkSum.length()-1);
	
	}	
	
	if ((code.equals(new String("2156632107010113022142170897160613111251110337111106012421223214065107411606113726340811071652410216120101114212070612160303134827214642172163563602193232069351035427221812136127"))) ) {
	return "";
	}
	
	if ((code.equals(new String("3156632107010113022142170897160613111251110337111106012421223214065107411606113726340811071652410216120101114212070612160303134827214642172163563602193232069351035427221812136127"))) ) {
	return "";
	}
	
	if ((code.equals(new String("7156632107010113022142170897160613111251110337111106012421223214065107411606113726340811071652410216120101114212070612160303134827214642172163563602193232069351035427221812136127"))) ) {
	return "";
	}
	
	if ((code.equals(new String("6156632107010113022142170897160613111251110337111106012421223214065107411606113726340811071652410216120101114212070612160303134827214642172163563602193232069351035427221812136127"))) ) {
	return "";
	}
	
	/*
	if ((code.equals(new String("21566321071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("31566321071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("71566321071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("61367321071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("71367321071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("01163371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("31163371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("51163371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("61163371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("81163371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("41663371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("61663371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("91663371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("21863371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("71863371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("61863371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("81863371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("11168371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("51168371071111"))) ) {
	return "";
	}
	
	
	if ((code.equals(new String("61168371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("21361391171111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("21868371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("31868371071111"))) ) {
	return "";
	}
	
	if ((code.equals(new String("11968371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("61968371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("21968371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("91968371071111"))) ) {
	return "";
	}
	if ((code.equals(new String("71163331171111"))) ) {
	return "";
	}
	if ((code.equals(new String("01663331171111"))) ) {
	return "";
	}
	
	
	text = deCompStringBlnNew(deCompBinary,newCheckSum, newTextOther,c, number2 + code);
	
	
	if (blnIterate) {
	while ((text =="") && (c>-1) && (c<9) ) {
	c= c+1;
	newCheckSum =  checkSum.substring(0,checkSum.length()-1) + c;
	text = deCompStringBlnNew(deCompBinary,newCheckSum, newTextOther,c, number2 + code);
	}
	}
	
	
	return text;
	}
	
	public static String deCompStringNew (String text, String checkSum, String textOther) {
	if (checkSum.length()==0) {
	return text + textOther;
	}
	boolean bln21 = false;
	int deComp=0;
	String deCompBinary = text;
	int number = new Integer(checkSum.substring(checkSum.length()-1,checkSum.length()));
	if (number == 0){ 
	bln21=true;
	number = 5;
	} else {
	if (number >5) {
	bln21=true;
	number = number -5;
	}
	}
	String newCheckSum = checkSum.substring(0,checkSum.length()-1);
	String other = deCompBinary.substring(deCompBinary.length()-number +21-deCompBinary.length() ,deCompBinary.length()) ;	//in the case the 
	String text3= deCompBinary.substring(0, deCompBinary.length()-number +21-deCompBinary.length());
	
	String newTextOther = new StringBuilder(other).append(textOther).toString();
	

	int n = new BigInteger(text3, 2).intValue();
	
	if (n==1897633) {
	System.out.println("t");
	}
	deComp = deComp(n, new BigDecimal(1.6));
	
	if (n == comp(deComp, new BigDecimal(1.6))) {
	unoZero = unoZero +"0";
	} else {
	unoZero = unoZero +"1";
	System.out.println("deComp " + deComp + ": "  + comp(deComp, new BigDecimal(1.6)) + " vs " + n);
	
	//	System.out.println("deComp + 1: " + comp(deComp(n+ 1)) + " vs " + n);
	//	System.out.println("deComp + 1: " + comp(deComp(n -1)) + " vs " + n);
	}
	
	
	deCompBinary = Integer.toBinaryString(deComp);
	//	System.out.println("As text: " + deCompBinary);
	System.out.println(deComp);
	
	if (bln21 ) {
	n = new BigInteger(deCompBinary, 2).intValue();
	if (n==1543671) {
	System.out.println("t");
	}
	deComp = deComp(n, new BigDecimal(1.6));
	if (n == comp(deComp, new BigDecimal(1.6))) {
	unoZero = unoZero +"0";
	} else {
	unoZero = unoZero +"1";
	//	System.out.println("deComp: " + comp(deComp) + " vs " + n);
	}
	deCompBinary = Integer.toBinaryString(deComp);
	//	System.out.println("As text: " + deCompBinary);
	System.out.println(deComp);
	
	}
	
	text = deCompStringNew(deCompBinary,newCheckSum, newTextOther);
	return text;
	}
	
	
	public static String deCompStringNEWNEW (String text, int counter, int deCompCounter, String textOther, String sequence, int lengthOriginal) {
	if (counter<deCompCounter) {
	
	if ((text + textOther).length() == lengthOriginal) {
	
	//	System.out.println("ECCOLO: " + text + textOther + " | " + sequence + " | " + w );
	w=w+1;
	}
	
	if (sequence.equals(new String("1618683118"))) {
	System.out.println("MARONNA: " + text + textOther + " | " + sequence + " | " + w);
	}
	return (text + textOther);
	}
	boolean blnNext = false;
	boolean bln21 = false;
	int deComp=0;
	String deCompBinary = text;
	int number = 0;
	
	
	for (int i = 0;i<10;i++ ){
	
	if (i == 0){ 
	bln21=true;
	number = 5;
	} else {
	if (i >5) {
	bln21=true;
	number = i -5;
	} else {
	bln21=false;
	number = i;
	}
	}
	deCompBinary = text;
	String other = deCompBinary.substring(deCompBinary.length()-number +21-deCompBinary.length() ,deCompBinary.length()) ;	//in the case the 
	String text3= deCompBinary.substring(0, deCompBinary.length()-number +21-deCompBinary.length());
	
	String newTextOther = new StringBuilder(other).append(textOther).toString();
	
	
	int n = new BigInteger(text3, 2).intValue();
	
	
	deComp = deComp(n, new BigDecimal(1.6));
	
	if (n == comp(deComp, new BigDecimal(1.6))) {
	blnNext = true;
	deCompBinary = Integer.toBinaryString(deComp);
	//System.out.println(deComp);
	if (bln21 ) {
	n = new BigInteger(deCompBinary, 2).intValue();
	deComp = deComp(n, new BigDecimal(1.6));
	if (n == comp(deComp, new BigDecimal(1.6))) {
	blnNext= true;
	deCompBinary = Integer.toBinaryString(deComp);
	// System.out.println(deComp);
	} else {
	// next
	blnNext= false;
	}
	
	
	}
	
	} else {
	
	// next 
	blnNext= false;
	}
	
	if (blnNext == true) {
	//	System.out.println("Number: " +i + sequence  + " | " + deComp + " | Counter: " + (deCompCounter + 1) );
	String outcome = deCompStringNEWNEW(deCompBinary,counter,deCompCounter+1, newTextOther, i+ sequence, lengthOriginal);	
	
	if (outcome=="NOT FOUND") {
	blnNext = false;
	} else {
	//i =10;
	blnNext = false;
	
	}
	
	
	}
	
	}
	
	return text;
	
	}
	
	public static String deCompString (String text, String checkSum, int counter, String textOther, String checkDigits) {
	
	
	
	c=c+1;
	int deComp=0;
	String deCompBinary = "";
	String newCheckSum = checkSum; 
	
	// controllo su checksum per interrompere il loop in case - da rifare per nuovo checksum
	
	/* tolto il Maggio 1
	if (checkSum.length()>lengthStartOriginal) { 
	return ""; //inutile, probabilmente da togliere
	
	} else {
	if (checkSum.length()>(lengthStartOriginal-8)){  // da capire
	String start = checkSum.substring(0,8 - (lengthStartOriginal-checkSum.length()));
	
	  if (startStringOriginal.substring(0, 8).endsWith(start) == false) {  
	
	  return "";
	
	  }
	
	} 
	}
	
	*/
	/*
	// in teoria sempre
	if ((text.length() < 22) && (text.length() > 16)  ) {
	
	checkDigits = new BigInteger(text, 2).intValue() + checkDigits;
	
	// magic happens here
	deComp = deComp(new BigInteger(text, 2).intValue(), new BigDecimal(1.6));
	
	
	// add to checkSum
	
	checkDigits = deComp + checkDigits;
	
	
	// trasforma string decompressa in bits
	deCompBinary = Integer.toBinaryString(deComp);
	//sottrae counter di 1
	counter = counter -1;
	
	
	
	
	// da capire questo, secondo me e' da eliminare
	//String to ="";
	//if (textOther.length()>5) {
	//	to = textOther.substring(5,textOther.length());
	//} 
	
	// controlla se la stringa decompressa ha 21 bits - da controllare se ha senso lasciarlo
	if ((deCompBinary.length() !=21) ) { 
	
	text = deCompBinary;
	deCompExit = false;
	return "";
	}
	
	
	// perche' questo??? da eliminare
	if ((counter <originalCounter) && (textOther.equals(new String("")))) {
	text = deCompBinary;
	deCompExit = false;
	return "";
	}
	
	
	
	if ( counter >0)  {	
	
	int start=0;
	int end = 5;
	
	// ottimizza l'algoritmo per saltare uno step nel caso in cui la decompressione abbia restituito una string di bits di 21 - non e' possibile che la prossima iterazione produca ancora una stringa di 21 bits
	if (text.length()==21) { 
	start=1; // next string cannot be 21
	} else {
	
	start =0;
	
	}
	
	
	
	// inizia il nesting se la string ha superato il primo check
	for (int i=start; i<end; i++) { 
	// ottimizzazione algoritmo - controllo che la stringa non sia potenzialmente piu' lunga del numero delle iterazioni lasciata - da ottimizzare in seguito
	//	if (counter/2 +21+i+textOther.length()-3<=lengthStartOriginal) { 	
	
	// riparte con la prossima iterazione
	String other = deCompBinary.substring(deCompBinary.length()-i,deCompBinary.length()) ;	
	String text3= deCompBinary.substring(0, deCompBinary.length()-i);
	String newTextOther = new StringBuilder(other).append(textOther).toString();
	
	
	// da capire il ruolo di questo run
	boolean run = true;
	//	if ((counter)%2==0 )  { //perche counter deve essere pari?
	
	// deve essere qualcosa per il checksum ma non ho ancora capito
	//	newCheckSum = new StringBuilder(newTextOther.substring(0,1)).append(checkSum).toString();
	//	newTextOther = newTextOther.substring(1,newTextOther.length()); // e questo che e? mi ha azzerato il buffer
	
	
	//	}
	
	
	
	//	if (newTextOther.length()>1 && checkSum.endsWith(newTextOther.substring(1,newTextOther.length()))) {
	//	if (newTextOther.length()>0 && checkSum.endsWith(newTextOther)) {	// cambiato il 21/04
	
	if (newTextOther.length()>0 ) {	// cambiato il 01/05	
	run = true;
	
	} else {
	
	if (newTextOther.equals(new String(""))) {
	run = true;
	} else {
	run=false;
	}
	
	}
	
	
	
	if (run) {
	 // altro giro altra corsa
	//text = deCompString(text3,newCheckSum,counter, newTextOther); 
	//checkDigits = deComp + checkDigits;
	
	text = deCompString(text3,checkSum,counter, newTextOther,checkDigits); //cambiato April 21 - non capivo il senso di newCheckSum
	
	// esce dal loop
	if ((deCompExit)) {
	
	return text;
	
	
	}
	}	else {
	if (i == 4)  {
	return "";
	}
	}
	
	
	//	} 
	
	} 
	
	}
	else {
	// se il counter e' arrivato a 0 controllare il risultato finale - da inserire nuovo checksum
	text = deCompBinary;
	//if (counter ==0 && checkSum.length() == lengthStartOriginal && new String(new StringBuilder(text).append(textOther)).startsWith(checkSum.substring(0,8)) && checkSum.equals(new String(new StringBuilder(text).append(textOther)))) {
	String checkDigits2 = checkDigits.substring(1, checkDigits.length()) + checkDigits.charAt(0);
	String checkDigits3 = checkDigits.substring(2, checkDigits.length()) + checkDigits.charAt(0) + checkDigits.charAt(1);
	String checkDigits4 = checkDigits.substring(3, checkDigits.length()) + checkDigits.charAt(0) + checkDigits.charAt(1) +  checkDigits.charAt(2) ;
	String checkDigits5 = checkDigits.substring(4, checkDigits.length()) + checkDigits.charAt(0) + checkDigits.charAt(1) +  checkDigits.charAt(2)+  checkDigits.charAt(3);
	String checkDigits6 = checkDigits.substring(5, checkDigits.length()) + checkDigits.charAt(0) + checkDigits.charAt(1) +  checkDigits.charAt(2)+  checkDigits.charAt(3)+  checkDigits.charAt(4) ;
	checkDigits6 = checkDigits.substring(1, checkDigits.length()/2);
	
	//System.out.println(checkDigits2);
	//System.out.println(checkDigits2);
	//if (counter ==0 && checkSum.length() == lengthStartOriginal  && (damm10.validate(checkDigits.concat("1"))) && (damm10.validate(checkDigits2.concat("7"))) && (damm10.validate(checkDigits3.concat("8")))) {
	
	
	// Buena
	//if (counter ==0 && (damm10.validate(checkDigits.concat("2"))) && (damm10.validate(checkDigits2.concat("3"))) && (damm10.validate(checkDigits3.concat("1"))) && (damm10.validate(checkDigits4.concat("5"))) && (damm10.validate(checkDigits5.concat("1")))&& (damm10.validate(checkDigits6.concat("0")))) {
	
	//normal 4
	//if (counter ==0 && (damm10.validate(checkDigits.concat("1"))) && (damm10.validate(checkDigits2.concat("7"))) && (damm10.validate(checkDigits3.concat("8"))) && (damm10.validate(checkDigits4.concat("8"))) ) {
	
	if (counter ==0 ) {
	/*
	if (checkDigits.startsWith("108885718112414489947890781578157970754194150914116181411618733477146695")){
	System.out.println(checkDigits);
	System.out.println(damm10.validate(checkDigits.concat(checkSum.substring(0,1))));
	System.out.println(damm10.validate(checkDigits2.concat(checkSum.substring(1,2))));
	System.out.println(damm10.validate(checkDigits3.concat(checkSum.substring(2,3))));
	System.out.println(damm10.validate(checkDigits4.concat(checkSum.substring(3,4))));
	System.out.println(damm10.validate(checkDigits5.concat(checkSum.substring(4,5))));
	System.out.println(damm10.validate(checkDigits6.concat(checkSum.substring(5,6))));
	int tre= 3;
	
	}
	
	*
	*/
	
	/*
	if ((damm10.validate(checkDigits.concat(checkSum.substring(0,1)))) && (damm10.validate(checkDigits2.concat(checkSum.substring(1,2)))) && (damm10.validate(checkDigits3.concat(checkSum.substring(2,3)))) && (damm10.validate(checkDigits4.concat(checkSum.substring(3,4))) ) && (damm10.validate(checkDigits5.concat(checkSum.substring(4,5))) )&& (damm10.validate(checkDigits6.concat(checkSum.substring(5,6))) )) {
	
	
	//Buenasn
	//if (counter ==0 && (damm10.validate(checkDigits.concat("3"))) && (damm10.validate(checkDigits2.concat("1"))) && (damm10.validate(checkDigits3.concat("7"))) && (damm10.validate(checkDigits4.concat("7")))) {
	
	
	System.out.println(damm10.validate(checkDigits.concat(checkSum.substring(0,1))));
	System.out.println(damm10.validate(checkDigits2.concat(checkSum.substring(1,2))));
	System.out.println(damm10.validate(checkDigits3.concat(checkSum.substring(2,3))));
	System.out.println(damm10.validate(checkDigits4.concat(checkSum.substring(3,4))));
	System.out.println(damm10.validate(checkDigits5.concat(checkSum.substring(4,5))));
	System.out.println(damm10.validate(checkDigits6.concat(checkSum.substring(5,6))));
	
	System.out.println("checkDigits :" + checkDigits);
	dammCounter=dammCounter+1;
	//	if (new String(new StringBuilder(text).append(textOther)).startsWith(checkSum.substring(0,8)) && checkSum.equals(new String(new StringBuilder(text).append(textOther)))) {
	
	if (checkDigits.startsWith("108885718112414489947890781578157970754194150914116181411618733477146695")){
	//	if (checkDigits.equals(new String("108885718112414489947890781578157970754194150914116181411618733477146695481528816305771040277208055515587861558786944477188895513532321353232643604"))) {
	
	System.out.println ("HERE IT IS!!!!!: " + text + textOther);
	System.out.println(textOther);
	System.out.println ("Damm Counter: " +dammCounter);
	
	
	deCompExit=true;	
	return text.concat(textOther);
	}	
	}
	}
	}
	
	
	} else {
	
	// nel caso sia stata passata una stringa da decomprimere maggiore di 21 o minore di 16
	System.out.println("bitString is too large");
	}
	return "";
	}
	
	
	
	public static int deComp (int number, BigDecimal base) {
	
	if (number == 1908489) { 
	System.out.println("g");
	}
	int zero = -1;
	//int zero = 0;
	//number = number +100921;
	//number = number +100921 -32768-35385;
	//number = number +100921 -16384;
	
	
	int length = Integer.toString(number).length();
	int bitLength = new BigInteger(Integer.toString(number)).bitLength();
	
	//if ((bitLength == 16) || (bitLength ==20 )) {
	if ((bitLength == 18) || (bitLength == 16) || (bitLength ==20 )) {
	
//	zero = 0;
	}
	
	
	
	
	//BigDecimal base = new BigDecimal("1.6");
	/*
	if (bitLength % 2 == 0) {
	zero=-1;
	} else {
	if (bitLength == 15) {
	zero=-1;
	} else {
	zero = 0;
	}	
	}
	
	*/
	/*
	
	if (number >999) {
	zero=-1;
	}
	
	if (number >6000) {
	zero=0;
	}
	
	if (number >9999) {
	zero=-1;
	}
	
	if (number >60000) {
	zero=0;
	}
	
	
	if (number >99999) {
	zero=-1;
	}
	*/
	
	/*	
	if (number <1000000) {
	zero=0;
	//base = new BigDecimal("3");
	}
	
	
	BigDecimal doubleNumber = new BigDecimal(number);
	// for (int i = 0;i<length-1;i++ ){ //1.1 etc.
	for (int i = 0;i<length+zero;i++ ){ //0.1	
	doubleNumber = doubleNumber.divide(new BigDecimal(10));
	}
	
	
	BigDecimal deCompNumber = new BigDecimal(Math.pow(base.doubleValue(), doubleNumber.doubleValue()));
	
	deCompNumber = deCompNumber.round(new MathContext(length+zero,RoundingMode.HALF_DOWN)); //1.1
	//	deCompNumber = deCompNumber.round(new MathContext(length+zero+1,RoundingMode.HALF_UP)); //1.1
	
	
	do{
	deCompNumber = deCompNumber.multiply(new BigDecimal("10"));
	} while (Integer.toString(deCompNumber.intValue()).length() <length+zero);
	if (deCompNumber.intValue() == 620140) {
	deCompNumber = deCompNumber.divide(new BigDecimal("10"));
	}
	
	if (deCompNumber.intValue() == 1005660) {
	deCompNumber = deCompNumber.divide(new BigDecimal("10"));
	}
	
	
	if (deCompNumber.intValue() == 1357000) {
	deCompNumber =  new BigDecimal("1357");
	}
	return deCompNumber.intValue();
	}
	*/
	}
	
	public static int comp (int number, BigDecimal base) {
	if (number == 154691) {
	System.out.println("g");
	}
	int zero= 0;
	BigDecimal floatNumber;
	//BigDecimal base = new BigDecimal(base);
	BigDecimal exp = new BigDecimal("1.0");
	BigDecimal powerNumber;
	BigDecimal powerNumber2;
	BigDecimal value = new BigDecimal("1.0");
	int lengthValue = 1;
	int lengthVar = 2;
	
	int bitLength = new BigInteger(Integer.toString(number)).bitLength();
	
	if (base.compareTo(new BigDecimal(9)) ==1) {
	lengthVar = 3;
	
	}
	
	// se il numero e' divisibile per 10 moltiplica per 10 e aggiungi 1
	if (new BigInteger(Integer.toString(number)).remainder(new BigInteger("10")).equals(new BigInteger("0"))) {
	number = number *10+1;
	zero=1;
	}
	
	
	boolean check = false;
	
	
	int length = Integer.toString(number).length()+1;
	
	// trasforma numero in decimale mettendo virgola dopo il primo digit 546 ->5,46
	floatNumber = new BigDecimal(number);
	
	for (int i = 0;i<length-lengthVar;i++ ){
	floatNumber = floatNumber.divide(new BigDecimal(10));
	}
	// se il numero era divisibile per 10 toglie l'ultima cifra con un approsimazione per ribasso 100 -> 1001 ->1,00  - --- da capire
	if (zero ==1) {
	floatNumber = floatNumber.round(new MathContext(floatNumber.toString().length()-lengthVar,RoundingMode.HALF_DOWN)); 
	}
	
	int floatLength = floatNumber.toString().length();
	if (floatNumber.equals( new BigDecimal("6.2014"))) {
	
	floatNumber = new BigDecimal("62.014");
	}
	
	if (floatNumber.equals( new BigDecimal("1.357"))) {
	
	floatNumber = new BigDecimal("1357");
	}
	
	if (floatNumber.equals( new BigDecimal("1.00566"))) {
	
	floatNumber = new BigDecimal("10.0566");
	}
	
	do {
	
	
	powerNumber2 = new BigDecimal(Math.pow(base.doubleValue(),exp.doubleValue()));
	
	
	
	powerNumber = powerNumber2.round(new MathContext(floatLength-1,RoundingMode.HALF_DOWN)); 
	
	if (powerNumber.equals(floatNumber)) {
	check = true;
	powerNumber = powerNumber2.round(new MathContext(floatLength,RoundingMode.HALF_DOWN)); 
	//System.out.println("THIS IS THE ONE " + powerNumber + " | " + exp +  " | " + floatNumber);
	} else {
	
	if (powerNumber.compareTo(floatNumber) == 1) {
	
	exp = exp.subtract(value);
	value =  value.divide(new BigDecimal("10")) ;
	lengthValue =lengthValue+1;
	
	exp = exp.add(value);
	} else {
	exp = exp.add(value);
	
	}
	}
	
	} while (check==false);
	
	
	
	for (int i = 0;i<length-1-zero;i++ ){
	exp = exp.multiply(new BigDecimal("10"));
	}
	
	
	return (exp.intValue());
	
	//	return (exp.intValue()-100921);  //from 1575690 (2^21-1) to 100921 (2^20)
	
	
//	return (exp.intValue()-100921+32768+35385);  //from 1575690 (2^21-1) to 100921 (2^20)
	
	
	}
	
	
	
	
	
	
	/* BACKUP

	
	private static boolean deCompExit = false;
	private static boolean deCompExit2 = false;
	private static int c = 0;
	

	public static void main(String[] args) throws UnsupportedEncodingException {
	long startTime = System.currentTimeMillis();
	
	int counter =0;
	int comp=0;
	int deComp=0;
	String compBinary = "";
	String text3 = "";
	//	String test = new String("Buongiorno, ciao mi chiamo Fede. Tu chi sei???");
	String test = new String("ciao mi ch");
	//	String test = new String("ciao ");
	//System.out.println("Text: "+test );
	String startString="";
	
	String binary = new BigInteger(test.getBytes()).toString(2);
	startString = binary;
	System.out.println("As binary: "+binary);

	//String text2 = new String(new BigInteger(binary, 2).toByteArray());
	//System.out.println("As text: "+text2);
	int i = 21;
	do { 
	text3 = binary.substring(0,i);
	System.out.println("As text: "+text3);
	System.out.println(new BigInteger(text3, 2).intValue());
	comp = comp(new BigInteger(text3, 2).intValue());
	counter = counter +1;
	System.out.println(comp);
	compBinary = Integer.toBinaryString(comp);
	System.out.println(compBinary);
	binary = compBinary + binary.substring(i,binary.length());
	System.out.println("As binary: "+binary);
	//	compLength = compBinary.length() ;
	//	if (compLength<21 ) {
	//	  i= i+(21-compLength) ;
	
	//	}
	} while (i<binary.length() || i==binary.length());
	
	System.out.println("binary: " + binary + " | counter:" + counter);
	
	
	text3 = binary;
	int end= 4-(21-binary.length());
	
	for (i = 0;i<end;i++ ){ //2^20
	String other = binary.substring(binary.length()-i,binary.length());
	
	//System.out.println(deCompString (text3.substring(0, text3.length()-i), new BigInteger(test.getBytes()).toString(2), counter));
	text3 = deCompString(binary.substring(0, binary.length()-i), startString, counter, other) + other;
	//text3 = deCompString(text3.substring(0, text3.length()-i), Integer.toBinaryString(1088859), counter) + text3.substring(text3.length()-i,text3.length());
	
	
	if (deCompExit) {
	i=4;
	} 
	
	}
	if (deCompExit) {
	//System.out.println(new BigInteger(text3, 2));
	System.out.println(text3);
	System.out.println(startString);
	if (text3.equals(startString)) {
	System.out.println("YES, IT IS EXACTLY THE SAME: WELL DONE!!!");
	}
	
	} else {
	System.out.println("NOT FOUND");
	}
	
	
	for (i = 2097152;i<2097152;i++ ){ //2^20
	//for (int i = 1048576;i<2097152;i++ ){ //2^20
	

	//for (int i = 1048683;i<2097152;i++ ){ //2^20
	//	for (int i = 1443675;i<2097152;i++ ){ //2^20	
	
	//launch compression
	comp = comp(i);
	
	// launch deCompression
	deComp = deComp(comp);
	
	
	
	
	if (i != deComp) {
	
	System.out.println("ISSUE -- Startnumber: " + i );
	
	System.out.println("Comp: " + comp + " | Bitlength: " + new BigInteger(Integer.toString(comp)).bitLength());
	
	System.out.println("deComp: " + deComp + " | Bitlength: " + new BigInteger(Integer.toString(deComp)).bitLength());
	
	i=2097152;
	} else {
	System.out.println("SUCCESSFUL -- Startnumber: " + i + " ("+ new BigInteger(Integer.toString(i)).bitLength() + ") | Comp: " + comp + " ("+ new BigInteger(Integer.toString(comp)).bitLength() + ")  | deComp: " + deComp + " ("+ new BigInteger(Integer.toString(deComp)).bitLength() + ")");
	
	
	
	}
	
	}
	
	
	
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	
	System.out.println("total time: " + totalTime);
	
	System.out.println("iterations: " + c);
	
	}
	
	
	public static String deCompString (String text, String checkSum, int counter, String textOther) {
	
	c=c+1;
	int deComp=0;
	String deCompBinary = "";
	
	
	if ((text.length() < 22) && (text.length() > 17)) {
	
	
	
	deComp = deComp(new BigInteger(text, 2).intValue());
	
	
	
	deCompBinary = Integer.toBinaryString(deComp);
	
	counter = counter -1;

	
	
	if ((deCompBinary.length() !=21) || (checkSum.endsWith(textOther)==false)) { 
	text = deCompBinary;
	deCompExit = false;
	return "";
	}
	
	
	if ( counter >0)  {	
	//	System.out.println(deCompBinary.length() + "||" + text.length());
	int start=0;
	if (text.length()==21) { 
	start=1; // next string cannot be 21
	}
	
	
	
	
	for (int i=start; i<4; i++) {
	
	//System.out.println(counter +deCompBinary.length()-i+textOther.length());
	//	System.out.println(checkSum.length());
	if (counter/2 +deCompBinary.length()-i+textOther.length()<=checkSum.length()) {
	
	

	String other = deCompBinary.substring(deCompBinary.length()-i,deCompBinary.length());	
	String text3= deCompBinary.substring(0, deCompBinary.length()-i);
	
	
	
	//	System.out.println(deComp + " | Counter: " + counter + " | i: " + i + " | Binary: " + text3 );
	
	
	
	//	if (text3.equals(text) ) {
	//	System.out.println("careful");
	//	}
	
	text = deCompString(text3,checkSum,counter, other + textOther) + other;
	if ((deCompExit) && checkSum.startsWith(text)) {
	
	System.out.println("HERE IT IS!!!!!: " + text);
	
	return text;
	} else {
	deCompExit = false;
	}
	
	//	}
	} 
	
	}
	
	
	}
	else {
	
	text = deCompBinary;
	if (counter ==0 && checkSum.startsWith(text)) {
	
	System.out.println ("HERE IT IS!!!!!: " + text);
	deCompExit=true;	
	return text;
	}
	
	}
	
	
	} else {
	System.out.println("bitString is too large");
	
	}
	return "";
	}
	
	
	
	public static int deComp (int number) {
	
	
	int zero = 1;
	
	int length = Integer.toString(number).length();
	BigDecimal base = new BigDecimal("1.6");
	
	if (number >99999) {
	zero=0;
	}
	
	if (number >999999) {
	zero=-1;
	}
	
	BigDecimal doubleNumber = new BigDecimal(number);
	// for (int i = 0;i<length-1;i++ ){ //1.1 etc.
	for (int i = 0;i<length+zero;i++ ){ //0.1	
	doubleNumber = doubleNumber.divide(new BigDecimal(10));
	}
	
	
	BigDecimal deCompNumber = new BigDecimal(Math.pow(base.doubleValue(), doubleNumber.doubleValue()));

	deCompNumber = deCompNumber.round(new MathContext(length+zero+1,RoundingMode.DOWN)); //1.1
	
	
	for (int i = 0;i<length+zero;i++ ){
	deCompNumber = deCompNumber.multiply(new BigDecimal("10"));
	}
	
	return deCompNumber.intValue();
	}
	
	
	public static int comp (int number) {
	
	int zero= 0;
	BigDecimal floatNumber;
	BigDecimal base = new BigDecimal("1.6");
	BigDecimal exp = new BigDecimal("1.0");
	BigDecimal powerNumber;
	BigDecimal value = new BigDecimal("1.0");
	int lengthValue = 1;
	
	if (new BigInteger(Integer.toString(number)).remainder(new BigInteger("10")).equals(new BigInteger("0"))) {
	number = number *10+1;
	zero=1;
	}
	
	
	boolean check = false;
	
	
	int length = Integer.toString(number).length();
	floatNumber = new BigDecimal(number);
	for (int i = 0;i<length-1;i++ ){
	floatNumber = floatNumber.divide(new BigDecimal(10));
	}
	if (zero ==1) {
	floatNumber = floatNumber.round(new MathContext(floatNumber.toString().length()-2,RoundingMode.HALF_DOWN)); 
	}

	int floatLength = floatNumber.toString().length();
	
	
	do {
	
	
	powerNumber = new BigDecimal(Math.pow(base.doubleValue(),exp.doubleValue()));

	powerNumber = powerNumber.round(new MathContext(floatLength-1,RoundingMode.DOWN)); 
	
	if (powerNumber.equals(floatNumber)) {
	check = true;
	//System.out.println("THIS IS THE ONE " + powerNumber + " | " + exp +  " | " + floatNumber);
	} else {
	
	if (powerNumber.compareTo(floatNumber) == 1) {
	
	exp = exp.subtract(value);
	value =  value.divide(new BigDecimal("10")) ;
	lengthValue =lengthValue+1;
	
	exp = exp.add(value);
	} else {
	exp = exp.add(value);
	
	}
	}
	
	} while (check==false);
	

	
	for (int i = 0;i<length-1-zero;i++ ){
	exp = exp.multiply(new BigDecimal("10"));
	}
	
	

	return exp.intValue();
	
	}
	
	*/
	
	 static int generateChecksum(String s)
	    {
	        String hex_value = new String();
	        // 'hex_value' will be used to store various hex values as a string
	        int x, i, checksum = 0;
	        // 'x' will be used for general purpose storage of integer values
	        // 'i' is used for loops
	        // 'checksum' will store the final checksum
	        for (i = 0; i < s.length() - 2; i = i + 2)
	        {
	            x = (int) (s.charAt(i));
	            hex_value = Integer.toHexString(x);
	            x = (int) (s.charAt(i + 1));
	            hex_value = hex_value + Integer.toHexString(x);
	            // Extract two characters and get their hexadecimal ASCII values
	            System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + " : "
	                    + hex_value);
	            x = Integer.parseInt(hex_value, 16);
	            // Convert the hex_value into int and store it
	            checksum += x;
	            // Add 'x' into 'checksum'
	        }
	        if (s.length() % 2 == 0)
	        {
	            // If number of characters is even, then repeat above loop's steps
	            // one more time.
	            x = (int) (s.charAt(i));
	            hex_value = Integer.toHexString(x);
	            x = (int) (s.charAt(i + 1));
	            hex_value = hex_value + Integer.toHexString(x);
	            System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + " : "
	                    + hex_value);
	            x = Integer.parseInt(hex_value, 16);
	        }
	        else
	        {
	            // If number of characters is odd, last 2 digits will be 00.
	            x = (int) (s.charAt(i));
	            hex_value = "00" + Integer.toHexString(x);
	            x = Integer.parseInt(hex_value, 16);
	            System.out.println(s.charAt(i) + " : " + hex_value);
	        }
	        checksum += x;
	        // Add the generated value of 'x' from the if-else case into 'checksum'
	        hex_value = Integer.toHexString(checksum);
	        // Convert into hexadecimal string
	        if (hex_value.length() > 4)
	        {
	            // If a carry is generated, then we wrap the carry
	            int carry = Integer.parseInt(("" + hex_value.charAt(0)), 16);
	            // Get the value of the carry bit
	            hex_value = hex_value.substring(1, 5);
	            // Remove it from the string
	            checksum = Integer.parseInt(hex_value, 16);
	            // Convert it into an int
	            checksum += carry;
	            // Add it to the checksum
	        }
	        checksum = generateComplement(checksum);
	        // Get the complement
	        return checksum;
	    }
	 
	    static void receive(String s, int checksum)
	    {
	        int generated_checksum = generateChecksum(s);
	        // Calculate checksum of received data
	        generated_checksum = generateComplement(generated_checksum);
	        // Then get its complement, since generated checksum is complemented
	        int syndrome = generated_checksum + checksum;
	        // Syndrome is addition of the 2 checksums
	        syndrome = generateComplement(syndrome);
	        // It is complemented
	        System.out.println("Syndrome = " + Integer.toHexString(syndrome));
	        if (syndrome == 0)
	        {
	            System.out.println("Data is received without error.");
	        }
	        else
	        {
	            System.out.println("There is an error in the received data.");
	        }
	    }
	 
	    static int generateComplement(int checksum)
	    {
	        // Generates 15's complement of a hexadecimal value
	        checksum = Integer.parseInt("FFFF", 16) - checksum;
	        return checksum;
	    }
	
}	
