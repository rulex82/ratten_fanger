import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.BitSet;

public class RattenFangerV2 {
	private static int oldbitL = 0;
	
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
	
	public static BitSet increment(BitSet bs) {
	    
	int first0= bs.nextClearBit(0);
	
	if (first0>0) {
	bs.flip(0, first0);
	} 
	bs.set(first0);
	
	
	    return bs;
	}

	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	long startTime = System.currentTimeMillis();
	
	boolean newCode = true;
	int bcounter =0;
	
	
	//System.out.println(unPack(new BigInteger("101110000000000011100100000000010111111111",2),1));  //1110001110111111111111 *2
	
	//	System.out.println( new BigInteger("1110001110111111111111",2));
	
//	BigInteger ren = new BigInteger("2097151");
//	ren = unPack(new BigInteger("11010010000100110111011010110000010110011000100011100011011001110000010100101101110",2),51);
//	ren = unPack(new BigInteger("110100000000010101111111110110100100001001101101000100110001100001010000010111111111",2),75);
	
	//	System.out.println(new BigInteger("10110010010101",2));
	//	System.out.println(BitSet.valueOf(new long[] {11413}).toString());
//	ren = unPack(new BigInteger("10110010010101",2),410);
	
	// String bits = "100001000001000000010000011111010100111011101010110110000001010011011000000100111100100110010001"; //1010
	 //System.out.println(Pack(bs,200));
	
	
	
	 String bits = "11111101111100101110111000100111000101110110000110000001010001110101001100100000"; //1010 //90
	
//	 bits = "11100000000111110011000011000101000000110000000001011110001111001100001010000001010100011001000"; //1
//	  bits = "1111101100100000001101010100101000011000111111011001111101110100011011100101010010100111"; // 10
	//  bits = "100001000001000000010000011111010100111011101010110110000001010011011000000100111100100110010001"; // 5
	// bits= "101001010100011000100101001000011011111101110100110100101101011101111100"; //100
	// bits="100011010111101101110100000011100001101011010011001100010011011"; //200
//	 bits ="1110110000000001110110001100001100000010100000111101100000000011101100011000011000000101000001"; //0
	 
	 
	 /* remove this for Pack
	 bits ="11101100000000011101100011000011000000101000001";
	 
	
	      
	 BitSet source = new BitSet(bits.length());
	 
	 for (int i = 0; i < bits.length(); i++) {
	        if (bits.charAt(bits.length()-i-1) == '1') {
	            source.set(i);
	        } else {
	            source.clear(i);
	        }
	    }
	 
	 System.out.println(source);
	//source.or(shiftRight(source,source.length()));
	//System.out.println(source);
	
	// System.out.println(BitSet.valueOf(shiftR(source.toLongArray(),64)));
	 
	 bits = "10110010010101"; //410
	*/ 
	 
	 BitSet bs = new BitSet(bits.length());

	 
	 
	for (int i = 0; i < bits.length(); i++) {
	    if (bits.charAt(bits.length()-i-1) == '1') {
	        bs.set(i);
	    } else {
	        bs.clear(i);
	    }
	}
	System.out.println(bs); //{0, 2} so 0th index and 2nd index are set. 
 	for (int i=0; i<bs.toLongArray().length;i++) {
 		System.out.println(bs.toLongArray()[i]);
 	
 	}
	 	/* -- remove this for Pack
	 	BitSet bscomp = new BitSet();
	 	BitSet bspack = new BitSet ();
	 
	 	bspack.set(1);
	 	bspack.set(3);
	bspack.set(4);
	 	bspack.set(7);
	 	bspack.set(9);
	 	bspack.set(10);
	 	bspack.set(11);
	 	bspack.set(12);
	 	bspack.set(13);
	bspack.set(14);
	 	bspack.set(19);
	
	 	bspack.set(22);
	 	bspack.set(23);

	 	bspack.set(44);
	//bspack.set(44);
	int scounter = 7;
	BitSet bsstop = new BitSet();
	bsstop.set(48);
	//bspack = source;
	
	System.out.println(bspack); //{0, 2} so 0th index and 2nd index are set. 
	
	do {
	bspack = increment(bspack);
	bscomp = (BitSet) bspack.clone();
	bscomp.or(shiftRight(bscomp,bscomp.length()));
	//	System.out.println(bscomp);

	bscomp = Pack(bscomp,410);
	if (bscomp.equals(bs)) {
	scounter ++;
	System.out.println(scounter);
	}
	
	//	System.out.println(bspack); //{0, 2} so 0th index and 2nd index are set. 
	
	} while (!bspack.equals(source) && !bspack.equals(bsstop));
	
	System.out.println(bscomp);
	System.out.println(bspack);
	System.out.println(scounter);
	
	 /*
	 //bs = BitSet.valueOf(new byte[] {3,5,7});
	 long[] by = bs.toLongArray();
	 for (int i =0; i< by.length; i++) {
	 System.out.println(by[i]);
	 }
	 
	long q = 7;

	System.out.println(q & by[0]); //last 3 digits of byte
	System.out.println(BitSet.valueOf(new long[] {by[0]}));
	System.out.println(BitSet.valueOf(new long[] {by[0]>>2 | by[1]>>2}));
	*/
	//BitSet f = unPackV2(BitSet.valueOf(new long[] {11413}),410);
	
	// BitSet f = unPackV5(bs,90);
 	oldbitL = bs.length();
 	long [] f = unPackV7(bs.toLongArray(),90);
 	System.out.println(BitSet.valueOf(f));
	//	System.out.println(f.toString());
	
//	ren = unPack(new BigInteger("1000011111001001110111111101001010100101010000101100101100011000100111000100111111000100",2),20);	
	
//	ren = unPack(new BigInteger("101011001011010001100000100110000100100000001101000111111101011000010101101001011100",2),30);
//	ren = unPack(new BigInteger("100110011000000110000011010100000001000000100101101010110010001111011110111001101110",2),28);	
//	ren = unPack(new BigInteger("100110000000001111011000111000110100100111101010001011100000000111010010100110100010",2),34);
	//	ren = unPack(new BigInteger("1111000110010000001110001011001000100011001111000110101101100010100000000100100",2),89);
	
	//	ren = unPack(new BigInteger("1111101100100000001101010100101000011000111111011001111101110100011011100101010010100111",2),10);
	//	ren = unPack(new BigInteger("100001000001000000010000011111010100111011101010110110000001010011011000000100111100100110010001",2),5);
	//System.out.println(ren);
	
	System.out.println( new BigInteger("11101100000000011101100011000011000000101000001",10));
	long endTime   = System.currentTimeMillis();
	long totalTime = endTime - startTime;
	
	System.out.println("total time: " + totalTime);

	
	
	/*
	
	
	
	//ren = new BigInteger("15").pow(12);
	//System.out.println(ren);
	ren = new BigInteger("1110110000000001110110001100001100000010100000111101100000000011101100011000011000000101000001",2);
	
	
	
	int bitL = ren.bitLength();
	String bitC = "";
	
	if (ren.bitLength() % 4 >0){
	bitL = bitL + (4-(ren.bitLength() % 4)) ;
	
	}
	//System.out.println(ren.toString(2));
	System.out.println(powerCheck(ren));
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
	  //  }  while (powerCheck(ren) == -1);
	  }  while (bcounter <410);
	  
	System.out.println(bcounter + " | " + Integer.bitCount(bcounter));
	//System.out.println(ren.setBit(0));
	
	System.out.println(powerCheck(ren));
	
	
	ren = unPack(ren,bcounter);
	
	
	} else {
	
	do {
	bitC = "";
	//	bitL = ren.bitLength();  -- NEW CHANGe
	
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
	
	ren = ren.flipBit(e-3);
	ren= ren.flipBit(e-2);
	ren = ren.flipBit(e-1);
	
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
	
	//	System.out.println(powerCheck(ren));
	
	
	
	
	}
	*/
	 
	}
	public static byte[] addAll(final byte[] array1, byte[] array2, int l) {
	byte[] tarray1 = array1;
	int mod = l%8;
	int w= 0;
	int p=0;
	for (int e=mod-1; e>-1; e=e-1) {
	p= 1<<e ;
	w=w+p;
	}
	
	
	if (array1[array1.length-1] == 1) {
	tarray1= Arrays.copyOf(array1, array1.length-1);
	} else {
	tarray1[array1.length-1] = (byte) (array1[array1.length-1] &  w); //take only 
	}
	
	//tarray1= Arrays.copyOf(array1, array1.length-1);
	System.out.println(BitSet.valueOf(tarray1));
	
	byte[] joinedArray = Arrays.copyOf(tarray1, tarray1.length + array2.length);
	System.out.println(BitSet.valueOf(joinedArray));

	    System.arraycopy(array2, 0, joinedArray, tarray1.length, array2.length);
	    System.out.println(BitSet.valueOf(joinedArray));
	    return joinedArray;
	}

	public static BitSet Pack(BitSet r, int counter) {
	BitSet ren=r;
	
	int bCounter =0;
	
	do {
	
	BitSet a = new BitSet();
	//BitSet b=new BitSet();
	int bitL = ren.length();  
	int bLength = (bitL+3)/4;
	for (int e = 3;e<bitL+3;e=e+4 ) {

	
	int f= e/4;
	if (ren.get(e)) {
	a.set(bLength+e-3-f,!ren.get(e-3));
	a.set(bLength+ e-2-f,!ren.get(e-2));
	a.set(bLength+ e-1-f,!ren.get(e-1));
	
	a.set(f,true);
	
	} else {
	a.set(bLength+ e-3-f,ren.get(e-3));
	a.set(bLength+ e-2-f,ren.get(e-2));
	a.set(bLength+ e-1-f,ren.get(e-1));
	
	a.set(f,false);
	}
	if (e>bitL-2) {
	//	a.set(f+1,true);
	}	
	
	
	
	} 
	
	//	System.out.println(a);
	ren= a;
	//ren = BitSet.valueOf(addAll(b.toByteArray(),a.toByteArray(),b.length()-1));
	//	System.out.println(ren);
	bCounter = bCounter +1;

	}  while (bCounter <counter);
	
	
	
	return ren;
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





public static BitSet unPackV2(BitSet r, int counter) {
	
	BitSet a;	
	BitSet b;	
	BitSet c;	
	
	if (counter == 0) {
	a = r.get(0, r.length()/2);
	
	b = r.get(r.length()/2,r.length());
	
	if (a.equals(b)) {
	
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	return a;	
	
	} else {
	return BitSet.valueOf(new long[] {-2});
	}
	
	}	
	
	
	int bitL= r.length();
	
	
	if (bitL % 4 >0){
	bitL = bitL + (4-(bitL % 4)) ;
	
	}
	int start= bitL/4; //minimum number of blocks
	int i=start;

	do {
	bitL=bitL + (i-start)*4;
	a= r.get(i, r.length());
	// System.out.println(a.toString());
	b = new BitSet(i);
	//System.out.println(b.toString());
	b.set(i);
	//System.out.println(b.toString());
	b.or(r.get(0, i));
	/*
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	 System.out.println(b.length());
	 System.out.println(r.length());
	 */
	 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
	if ((bitL-r.length()==3) && (b.get(b.length()-2) == false )) {
	//	System.out.println ("discard");
	return BitSet.valueOf(new long[] {-1});
	}
	int diff = (b.length()-1)*3 - a.length();
	//String zero= "";
	
	//System.out.println(a.toString());
	a.set(a.length()+diff,true);
	
	
	
	// System.out.println(a.toString());
	
	for (int e = 0;e<b.length()-1;e++ ) {
	
	BitSet newA = (BitSet) a.clone();
	//	System.out.println(newA.toString());
	newA.clear(0, 4*e+3);
	//	System.out.println(newA.toString());
	newA=shiftRight(newA,1);
	//	fed 
	//BigInteger fed = new BigInteger(newA.toByteArray());
	//fed = fed.shiftRight(2);
	
	//newA = BitSet.valueOf(Arrays.stream(newA.toLongArray()).map(v -> v << 1).toArray());
	//newA = BitSet.valueOf(fed.toByteArray());
	//	System.out.println(newA.toString() + " | " + newA.length());
	//	System.out.println(a.get(0, 4*e+3));
	newA.or(a.get(0, 4*e+3));
	//	System.out.println(newA.toString());
	a= (BitSet) newA.clone();
	//	System.out.println(a.toString());
	if (b.get(e)) { // e==1
	a.set(4*e+3);
	//	System.out.println(a.toString());
	a.flip(4*e);
	//	System.out.println(a.toString());
	a.flip(4*e +1);
	//	System.out.println(a.toString());
	 a.flip(4*e +2);
	 //	System.out.println(a.toString());
	
	} else { //e==0

	a.set(4*e+3,false);
	// System.out.println(a.toString());
	
	}
	}
	
	a = a.get(0,a.length()-1);
//	System.out.println(a.toString());
	c=unPackV2(a,counter -1);
	
	

	if (i>24) {
	
	//	System.out.println(i);
	//	System.out.println(i);
	return (BitSet.valueOf(new long[] {-2}));
	} 
	if (c.equals(BitSet.valueOf(new long[] {-2}))  || c.equals(BitSet.valueOf(new long[] {-1})) ) {
	//	System.out.println("-2");
	
	} else {
	return c;
	}
	
	i= i +1;
	} while (r.get(i-1)==true); 	
	
	return c;
}



public static BitSet unPackV4(BitSet r, int counter) {
	
	BitSet a;	
	BitSet b;	
	BitSet c;	
	
	if (counter == 0) {
	a = r.get(0, r.length()/2);
	
	b = r.get(r.length()/2,r.length());
	
	if (a.equals(b)) {
	
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	return a;	
	
	} else {
	return BitSet.valueOf(new long[] {-2});
	}
	
	}	
	
	
	int bitL= r.length();
	
	
	if (bitL % 4 >0){
	bitL = bitL + (4-(bitL % 4)) ;
	
	}
	
	
	int start= bitL/4; //minimum number of blocks
	int i=start;

	do {
	bitL=bitL + (i-start)*4;
	a= r.get(i, r.length());
	// System.out.println(a.toString());
	b = new BitSet(i);
	//System.out.println(b.toString());
	b.set(i);
	//System.out.println(b.toString());
	b.or(r.get(0, i));
	/*
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	 System.out.println(b.length());
	 System.out.println(r.length());
	 */
	 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
	if ((bitL-r.length()==3) && (b.get(b.length()-2) == false )) {
	//	System.out.println ("discard");
	return BitSet.valueOf(new long[] {-1});
	}
	int diff = (b.length()-1)*3 - a.length();
	//String zero= "";
	
	//System.out.println(a.toString());
	//a.set(a.length()+diff,true);
	byte[] byteA = a.toByteArray();
	BitSet newA = new BitSet(r.length()+1);
	newA.set(r.length()+diff);
	// System.out.println(a.toString());
	
	for (int e = 0;e<b.length()-1;e++ ) {
	
	int e4 = e*4;
	int e41= e*4+1;
	int e42= e*4+2;
	//	System.out.println(newA.toString());
	
	//	System.out.println(newA.toString());
	//	newA=shiftRight(newA,1);
	//	fed 
	//BigInteger fed = new BigInteger(newA.toByteArray());
	//fed = fed.shiftRight(2);
	
	//newA = BitSet.valueOf(Arrays.stream(newA.toLongArray()).map(v -> v << 1).toArray());
	//newA = BitSet.valueOf(fed.toByteArray());
	//	System.out.println(newA.toString() + " | " + newA.length());
	//	System.out.println(a.get(0, 4*e+3));
	///newA.or(a.get(0, 4*e+3));
	//	System.out.println(newA.toString());
	//a= (BitSet) newA.clone();
	//	System.out.println(a.toString());
	if (b.get(e)) { // e==1
	newA.set(e4+3);
	//	System.out.println(a.toString());
	if (a.get(e4-e)==false) { newA.set(e4);}
	 //newA.set(e4,!a.get(e4-e));
	//	System.out.println(a.toString());
	if (a.get(e41-e)==false) { newA.set(e41);}
	//newA.set(e41,!a.get(e41-e));
	//	System.out.println(a.toString());
	if (a.get(e42-e)==false) { newA.set(e42);}
	//newA.set(e42,!a.get(e42-e));
	 //	System.out.println(a.toString());
	
	} else { //e==0

	//newA.set(e4+3,false);
	// System.out.println(a.toString());
	newA.set(e4, a.get(e4-e));
	newA.set(e41, a.get(e41-e));
	newA.set(e42, a.get(e42-e));
	
	}
	}
	
	//a = a.get(0,a.length()-1);
//	System.out.println(a.toString());
	c=unPackV4(newA.get(0,newA.length()-1),counter -1);
	
	

	if (i>24) {
	
	//	System.out.println(i);
	//	System.out.println(i);
	return (BitSet.valueOf(new long[] {-2}));
	} 
	if (c.equals(BitSet.valueOf(new long[] {-2}))  || c.equals(BitSet.valueOf(new long[] {-1})) ) {
	//	System.out.println("-2");
	
	} else {
	return c;
	}
	
	i= i +1;
	} while (r.get(i-1)==true); 	
	
	return c;
}

public static BitSet unPackV5(BitSet r, int counter) {
	
	BitSet a;	
	BitSet b;	
	
	
	
	if (counter == 0) {
	a = r.get(0, r.length()/2);
	
	b = r.get(r.length()/2,r.length());
	
	if (a.equals(b)) {
	
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	return a;	
	
	} else {
	return BitSet.valueOf(new long[] {-2});
	}
	
	}	
	
	
	int bitL= r.length();
	
	
	if (bitL % 4 >0){
	bitL = bitL + (4-(bitL % 4)) ;
	
	}
	
	int length = r.length();
	int start= bitL/4; //minimum number of blocks
	int i=start;
	byte buffer = 0;
	
	do {
	bitL=bitL + (i-start)*4;
	
	a= r.get(i, r.length());
	long[] al = a.toLongArray();
	
	   // a =null; // destroy object reference for memory purpose
	
	b = new BitSet(i);
	
	b.set(i);
	
	b.or(r.get(0, i));
	
	 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
	if ((bitL-length==3) ) {
	if (b.get(b.length()-2) == false ) {
	//	System.out.println ("discard");
	//	a= null;
	//	b= null;
	//	al =null;
	return BitSet.valueOf(new long[] {-1});
	}
	}

	
	byte[] ab = new byte[b.length()/2];
	
	for (int e = 0;e<b.length()-1;e++ ) {
	// take 3 digits

	
	buffer = (byte) (7 & al[0]); //take only last 3 digits 
	
	if (b.get(e) == true) {
	
	buffer = (byte) ~buffer;
	
	buffer = (byte) (15 & buffer); //take only last 4 digits
	
	}
	al = shiftL(al,3);
	
	buffer = (byte) (buffer << (e%2)*4);
	
	ab[e/2] = (byte) (ab[e/2] | buffer);
	
	
	
	}
	//	al = null;
	//	b = null;
	a=unPackV5(BitSet.valueOf(ab),counter -1);
	
	

	if (i>24) {
	//	al = null;
	//	b = null;
	//	a=  null;
	//	System.out.println(i);
	//	System.out.println(i);
	return (BitSet.valueOf(new long[] {-2}));
	} 
	if (a.equals(BitSet.valueOf(new long[] {-2}))  || a.equals(BitSet.valueOf(new long[] {-1})) ) {
	//	System.out.println("-2");
	
	} else {
	return a;
	}
	
	i= i +1;
	} while (r.get(i-1)==true); 	
	
	return a;
}

public static long[] unPackV7(long[] r, int counter) {
	
	long[] a;
	long[] b;
	long[] ab;
	int bitL;
	
	//check if it works
	
	if (r[r.length-1]>0) {
		bitL = (r.length-1)*64 + (int) ((Math.log(r[r.length-1])/Math.log(2)))+1;
	} else {
		
		bitL = (r.length)*64;

		
	}
	System.out.println(BitSet.valueOf(r));
	if (bitL/4<oldbitL/4-1) {
		System.out.println(BitSet.valueOf(r));
		return new long[] {-2};
	}
	oldbitL = bitL;	
	
	//} else {
		//bitL = (r.length-1)*64 + (int) ((Math.log(r[r.length-2])/Math.log(2)));
		
	//	bitL = (r.length-1)*64 ;
	//}
	
	
	
	if ((counter == 0) ) {
		
		if ( (bitL > 91) && (bitL < 96) ) {
			int half = bitL/2;
			a = r.clone();
			b= r.clone();
			System.out.println(BitSet.valueOf(r));
			b = shiftL(b,half+1);
			// da aggiungere masks
			long mask = 0;
			mask = ~mask;
			mask= mask >>> (64-half-1);
			a[0]=a[0] & mask;
			a[1]=0;
			
			if (a[0] == b[0]) {
			
				System.out.println(BitSet.valueOf(a));
				System.out.println(BitSet.valueOf(b));
				return a;	
			
			} else {
				
				return new long[] {-2};
			}	
		} else {
			return new long[] {-2};
		}
	}	

	int bitlength = bitL;
	if (bitL % 4 >0){
		bitL = bitL + (4-(bitL % 4)) ;
	
	}
	int start= bitL/4; //minimum number of blocks
	int i=start;

	if (i<0) {
		i=i;
	}
	
	//b= shiftL(b, bitlength-i+1);
	long ck;
	do {
		bitL=bitL + (i-start)*4;
		a =  r.clone();
		b= r.clone();
		//long[] b= new long[i/64];
		
		//System.out.println(BitSet.valueOf(a));
		//System.arraycopy(r, (bitL-i)/64, b, 0, i/64);	
		//b[0]= r[r.length];
		//b[b.length]= b[b.length] << (64-i);
		a = shiftL(a, i);
		System.out.println(BitSet.valueOf(a));
		ck = (b[0] & 1);
	//	System.out.println(BitSet.valueOf(b));

		 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
		if ((bitL-bitlength==3) ) {
			//if (b.get(b.length()-2) == false ) {
			if((b[0]<<1 & 1) == 0) {
				System.out.println(BitSet.valueOf(b));
//				return new long[] {-1};
			}
		}
	
		if (counter ==36) {
			ab = new long[((i-1)/16)+1];
			//ab = new long[((i)/16)+1];
		} else {
			ab = new long[((i-1)/16)+1];
			//ab = new long[((i)/16)+1];
		}	
		
		for (int e = 0;e<i;e++ ) {
		// take 3 digits
	
			
			long buffer = (7 & a[0]); //take only first 3 digits 
			
			if ((b[0] & 1)== 1) {
			
				buffer =  ~buffer;
				
				buffer = 15 & buffer; //take only first 4 digits
			
			}
			a = shiftL(a,3);
			b = shiftL(b,1);
			
			//System.out.println(BitSet.valueOf(a));
			//System.out.println(BitSet.valueOf(b));
			
			buffer = buffer << (e*4-(e/16*64));
			
			//controlla ultime 4 a che fare con shift l o line sotto
			
			ab[e/16] = (ab[e/16] | buffer);
			
		
		
		}
	
		System.out.println(BitSet.valueOf(ab));
		ab=unPackV7(ab,counter -1);
		
		
		i= i +1;
		if (i>24) {
		
			return (new long[] {-2});
		} 
		if ((ab[0] ==-1 )  ||  (ab[0] ==-2) ) {
		
		} else {
			return ab;
		}
		//i= i +1;
	
		System.out.println(BitSet.valueOf(b));
		b = shiftL(b,1);
		System.out.println(BitSet.valueOf(b));
	
	} while (ck ==1); 	
	
	return ab;
}


public static BitSet unPackV6(BitSet r, int counter) {
	
	BitSet a;	
	BitSet b;	
	BitSet c;	
	
	
	if (counter == 0) {
	a = r.get(0, r.length()/2);
	
	b = r.get(r.length()/2,r.length());
	
	if (a.equals(b)) {
	
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	return a;	
	
	} else {
	return BitSet.valueOf(new long[] {-2});
	}
	
	}	
	
	
	int bitL= r.length();
	
	
	if (bitL % 4 >0){
	bitL = bitL + (4-(bitL % 4)) ;
	
	}
	
	int length = r.length();
	int start= bitL/4; //minimum number of blocks
	int i=start;
	byte buffer = 0;
	
	do {
	bitL=bitL + (i-start)*4;
	
	a= r.get(i, r.length());
	long[] al = a.toLongArray();
	
	a =null; // destroy object reference for memory purpose
	
	b = new BitSet(i);
	
	b.set(i);
	
	b.or(r.get(0, i));
	
	 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
	if ((bitL-length==3) ) {
	if (b.get(b.length()-2) == false ) {
	//	System.out.println ("discard");
	return BitSet.valueOf(new long[] {-1});
	}
	}

	
	byte[] ab = new byte[b.length()/2];
	
	for (int e = 0;e<b.length()-1;e=e+2 ) {
	// take 3 digits

	
	buffer = (byte) (7 & al[0]); //take only last 3 digits 
	
	if (b.get(e) == true) {
	
	buffer = (byte) ~buffer;
	
	buffer = (byte) (15 & buffer); //take only last 4 digits
	
	}
	al = shiftL(al,3);
	
	buffer = (byte) (buffer << (e%2)*4);
	
	ab[e/2] = (byte) (ab[e/2] | buffer);
	
	
	
	}
	//b = null;
	c=unPackV6(BitSet.valueOf(ab),counter -1);
	
	

	if (i>24) {
	
	//	c=  null;
	//	System.out.println(i);
	//	System.out.println(i);
	return (BitSet.valueOf(new long[] {-2}));
	} 
	if (c.equals(BitSet.valueOf(new long[] {-2}))  || c.equals(BitSet.valueOf(new long[] {-1})) ) {
	//	System.out.println("-2");
	
	} else {
	return c;
	}
	
	i= i +1;
	} while (r.get(i-1)==true); 	
	
	return c;
}


public static BitSet unPackV3(BitSet r, int counter) {
	
	BitSet a;	
	BitSet b;	
	BitSet c;	
	
	if (counter == 0) {
	a = r.get(0, r.length()/2);
	
	b = r.get(r.length()/2,r.length());
	
	if (a.equals(b)) {
	
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	return a;	
	
	} else {
	return BitSet.valueOf(new long[] {-2});
	}
	
	}	
	
	
	int bitL= r.length();
	
	
	if (bitL % 4 >0){
	bitL = bitL + (4-(bitL % 4)) ;
	
	}
	int start= bitL/4; //minimum number of blocks
	int i=start; //V2
	for (i=start; r.get(i+1) == true && i<25; i++){
	
	}

	do {
	bitL=bitL + (i-start)*4;
	a= r.get(i, r.length());
	// System.out.println(a.toString());
	b = new BitSet(i);
	//System.out.println(b.toString());
	b.set(i);
	//System.out.println(b.toString());
	b.or(r.get(0, i));
	/*
	System.out.println(a.toString()); 
	System.out.println(b.toString());
	 System.out.println(b.length());
	 System.out.println(r.length());
	 */
	 // add check if pari con primo numero controllo 0 not valid - esempio 110 001 110 111 111 011111
	if ((bitL-r.length()==3) && (b.get(b.length()-2) == false )) {
	//	System.out.println ("discard");
	return BitSet.valueOf(new long[] {-1});
	}
	int diff = (b.length()-1)*3 - a.length();
	//String zero= "";
	
	//System.out.println(a.toString());
	a.set(a.length()+diff,true);
	
	
	
	// System.out.println(a.toString());
	
	for (int e = 0;e<b.length()-1;e++ ) {
	
	BitSet newA = (BitSet) a.clone();
	//	System.out.println(newA.toString());
	newA.clear(0, 4*e+3);
	//	System.out.println(newA.toString());
	newA=shiftRight(newA,1);
	//	fed 
	//BigInteger fed = new BigInteger(newA.toByteArray());
	//fed = fed.shiftRight(2);
	
	//newA = BitSet.valueOf(Arrays.stream(newA.toLongArray()).map(v -> v << 1).toArray());
	//newA = BitSet.valueOf(fed.toByteArray());
	//	System.out.println(newA.toString() + " | " + newA.length());
	//	System.out.println(a.get(0, 4*e+3));
	newA.or(a.get(0, 4*e+3));
	//	System.out.println(newA.toString());
	a= (BitSet) newA.clone();
	//	System.out.println(a.toString());
	if (b.get(e)) { // e==1
	a.set(4*e+3);
	//	System.out.println(a.toString());
	a.flip(4*e);
	//	System.out.println(a.toString());
	a.flip(4*e +1);
	//	System.out.println(a.toString());
	 a.flip(4*e +2);
	 //	System.out.println(a.toString());
	
	} else { //e==0

	a.set(4*e+3,false);
	// System.out.println(a.toString());
	
	}
	}
	
	a = a.get(0,a.length()-1);
//	System.out.println(a.toString());
	c=unPackV3(a,counter -1);
	
	

	if (i>24) {
	
	//	System.out.println(i);
	//	System.out.println(i);
	return (BitSet.valueOf(new long[] {-2}));
	} 
	if (c.equals(BitSet.valueOf(new long[] {-2}))  || c.equals(BitSet.valueOf(new long[] {-1})) ) {
	//	System.out.println("-2");
	
	} else {
	return c;
	}
	
	//i= i +1; V2
	i= i -1;
	} while (i>start-1); 	
//} while (r.get(i-1)==true); 	V2
	
	
	return c;
}


/**
 * Shifts a BitSet n digits to the left. For example, 0b0110101 with n=2 becomes 0b10101.
 *
 * @param bits
 * @param n the shift distance.
 * @return
 */
public static BitSet shiftLeft(BitSet bits, int n) {
    if (n < 0)
        throw new IllegalArgumentException("'n' must be >= 0");
    if (n >= 64)
        throw new IllegalArgumentException("'n' must be < 64");

    long[] words = bits.toLongArray();

    // Do the shift
    for (int i = 0; i < words.length - 1; i++) {
        words[i] >>>= n; // Shift current word
        words[i] |= words[i + 1] << (64 - n); // Do the carry
    }
    words[words.length - 1] >>>= n; // shift [words.length-1] separately, since no carry

    return BitSet.valueOf(words);
}




public static long[] shiftL(long[] array, int n) {
	if (n < 0)
	        throw new IllegalArgumentException("'n' must be >= 0");
   // if (n >= 64)
   //     	throw new IllegalArgumentException("'n' must be < 64");
    
	long[] words = array;
	
	for (int i = 0; i < words.length; i++) {
		if ( i==words.length-1) {
			words[i] = words[i]>>>n;
	
		} else {
	
			words[i] = words[i]>>>n | words[i+1]<<64-n;
	
		}	
    }
    
	
	return words;
}


/**
 * Shifts a BitSet n digits to the right. For example, 0b0110101 with n=2 becomes 0b000110101.
 *
 * @param bits
 * @param n the shift distance.
 * @return
 */
public static BitSet shiftRight(BitSet bits, int n) {
    if (n < 0)
        throw new IllegalArgumentException("'n' must be >= 0");
    if (n >= 64)
        throw new IllegalArgumentException("'n' must be < 64");

    long[] words = bits.toLongArray();

    // Expand array if there will be carry bits
    if (words[words.length - 1] >>> (64 - n) > 0) {
        long[] tmp = new long[words.length + 1];
        System.arraycopy(words, 0, tmp, 0, words.length);
        words = tmp;
    }

    // Do the shift
    for (int i = words.length - 1; i > 0; i--) {
        words[i] <<= n; // Shift current word
        words[i] |= words[i - 1] >>> (64 - n); // Do the carry
    }
    words[0] <<= n; // shift [0] separately, since no carry

    return BitSet.valueOf(words);
}

}