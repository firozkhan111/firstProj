package DemoProj;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {

  // private static final String FILENAME = "/home/nt/filename.txt";
   private static final String FILENAME = "/home/nt/13April.csv";

	public static void main(String[] args) 
	{

		String fileName = args[0];
		long randomNumber = Long.parseLong(args[1]);
		long numberOfRows = Long.parseLong(args[2]);


		BufferedWriter bw = null;
		FileWriter fw = null;  // (no use in code)

		try {

			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write("UCIC_ID,NO_OF_Accs,HNW_CATEGORY,vintage,EMAIL_UNSUBSCRIBE,OCCUP_ALL_NEW,city,dependents,zip,Balance_Amount,Transaction_Amount,Transaction_Type,Transaction_Channel,Transaction_Date,Product_Purchase,Product_Purchase_Date,Product_Amt,NEFT_TO_Beneficiary,NEFT_Amt,BilllPayRegisterDate,BilllPaymentDone,BillPaymentAmount,LOAN_Product_Type,LOAN_EMI_Transaction_Amount,LOAN_EMI_Transaction_Date,Product_LOAN_Maturity_Date,Product_Loan_Disbursal_Date,Bank_Charges_Type,Bank_Charges_Amount,Bank_Charges_Date,Complain_Date,Complain_Category,brn_code,age,Gender,Request_Logged_Date,Query_Logged_Date,CHeque_Bounce,Cheque_Bounce_Date");
			bw.append("\n");

			Random random = new Random(randomNumber);

			// random userid
             int ucLow = 1;
			//int ucHigh = 1000;
			int ucic=0;
			// no of access btwn 1 and 20
			int accLow = 1;
			int accHigh = 20;
			int accs;
			// hnw ctgry

			String[] hnwcatgry = { "yes", "no" };
			// vintage
			String[] vintage = { "yes", "no" };
			// email
			String[] email = { "yes", "no" };
			// occupation
			String[] occupation = { "business", "service" };
			// city
			String[] city = { "delhi", "agra", "gurgaon", "bangalore" };
			// no of dependents btwn 1 and 8
			int dpLow = 1;
			int dpHigh = 8;
			int dependents;
			// zipcode
			int zip;

			String[] prdctprchs = { "FD", "RD", "Mf" };
			String[] bilpay = { "yes", "no" };
			String[] loantyp = { "Agri", "PL", "HL" };

			String[] bnkchrgtyp = { "SMS", "ATMCharge", "NetBankingCharge", "Cheaquebookcharge" };
			String[] cmplnctgry = { "SMS", "ATM", "NetBanking" };

			String[] chqbnc = { "yes", "no" };

			// for inner j loop
			String[] trnstype = { "Dr", "Cr" };
			String[] trnschnl = { "ATM", "Branch", "Phone Banking", "Mobile Banking", "POS" };

			String[] gender = { "male", "female" };

			for (int i = 2; i < numberOfRows; i++) {

				// data for same 20 rows
				//ucic = random.nextInt(1000);
				//ucic = random.nextInt(ucHigh - ucLow) + ucLow;
				ucic++;					 
				bw.append(String.valueOf(ucic));
				 bw.append(",");

				accs = random.nextInt(accHigh - accLow) + accLow;
				 bw.append(String.valueOf(accs));
				 bw.append(",");

				int hnwint = random.nextInt(hnwcatgry.length);
				 bw.append(String.valueOf(hnwcatgry[hnwint]));
				 bw.append(",");

				int vint = random.nextInt(vintage.length);
				 bw.append(String.valueOf(vintage[vint]));
				 bw.append(",");

				int eint = random.nextInt(email.length);
				 bw.append(String.valueOf(email[eint]));
				 bw.append(",");

				int oint = random.nextInt(occupation.length);
				 bw.append(String.valueOf(occupation[oint]));
				 bw.append(",");

				int cint = random.nextInt(city.length);
				 bw.append(String.valueOf(city[cint]));
				 bw.append(",");

				int dpndint = random.nextInt(dpHigh - dpLow) + dpLow;
				 bw.append(String.valueOf(dpndint));
				 bw.append(",");

				zip = random.nextInt(10000000);
				 bw.append(String.valueOf(zip));
				 bw.append(",");
				// age
				int ageLow = 18;
				int ageHigh = 100;
				int age = random.nextInt(ageHigh - ageLow) + ageLow;
				// gender
				int gnint = random.nextInt(gender.length);

				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
				SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yyyy");

				
						int balnc = random.nextInt(1000000);
						bw.append(String.valueOf(balnc));
						bw.append(",");
						bw.append(String.valueOf(random.nextInt(10000)));
						bw.append(",");
						bw.append(String.valueOf(trnstype[random.nextInt(trnstype.length)]));
						bw.append(",");
						bw.append(String.valueOf(trnschnl[random.nextInt(trnschnl.length)]));
						bw.append(",");

						LocalDate startDate1 = LocalDate.of(2015, 1, 1); // start
																			// date
						long start1 = startDate1.toEpochDay();
						LocalDate endDate1 = LocalDate.of(2016, 1, 1); // end
																		// date
						long end1 = endDate1.toEpochDay();
						long trnsdate1 = ThreadLocalRandom.current().longs(start1, end1).findAny().getAsLong();
						try {
							Date date1 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate1)));
							bw.append(format2.format(date1));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");


// product details

						bw.append(String.valueOf(prdctprchs[random.nextInt(prdctprchs.length)]));
						bw.append(",");

						LocalDate startDate2 = LocalDate.of(2015, 1, 1); // start
																			// date
						long start2 = startDate2.toEpochDay();
						LocalDate endDate2 = LocalDate.of(2016, 1, 1); // end
																		// date
						long end2 = endDate2.toEpochDay();
						long trnsdate2 = ThreadLocalRandom.current().longs(start2, end2).findAny().getAsLong();
						try {
							Date date2 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate2)));
							bw.append(format2.format(date2));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");

						int pramt = random.nextInt(100000);
						bw.append(String.valueOf(pramt));
						bw.append(",");


// neft amt and date
						int neftamt = random.nextInt(10000);
						bw.append(String.valueOf(neftamt));
						bw.append(",");

						LocalDate startDate3 = LocalDate.of(2015, 1, 1); // start
																			// date
						long start3 = startDate3.toEpochDay();
						LocalDate endDate3 = LocalDate.of(2016, 1, 1); // end
																		// date
						long end3 = endDate3.toEpochDay();
						long trnsdate3 = ThreadLocalRandom.current().longs(start3, end3).findAny().getAsLong();
						try {
							Date date3 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate3)));
							bw.append(format2.format(date3));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");

	// bill details date done and amt

						LocalDate startDate4 = LocalDate.of(2015, 1, 1); // start
																			// date
						long start4 = startDate4.toEpochDay();
						LocalDate endDate4 = LocalDate.of(2016, 1, 1); // end
																		// date
						long end4 = endDate4.toEpochDay();
						long trnsdate4 = ThreadLocalRandom.current().longs(start4, end4).findAny().getAsLong();
						try {
							Date date4 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate4)));
							bw.append(format2.format(date4));
						} catch (Exception e) 
						{
							System.out.println("exception caught");
						}

						bw.append(",");

						bw.append(String.valueOf(bilpay[random.nextInt(bilpay.length)]));
						bw.append(",");

						int bilamt = random.nextInt(10000);
						bw.append(String.valueOf(bilamt));
						bw.append(",");


	// loan details type, emiamt, emi date, maturity date,
						// disburs date

						bw.append(String.valueOf(loantyp[random.nextInt(loantyp.length)]));
						bw.append(",");

						int emiamt = random.nextInt(10000);
						bw.append(String.valueOf(emiamt));
						bw.append(",");

						LocalDate startDate5 = LocalDate.of(2015, 1, 1); // start
																			// date
						long start5 = startDate5.toEpochDay();
						LocalDate endDate5 = LocalDate.of(2016, 1, 1); // end
																		// date
						long end5 = endDate5.toEpochDay();
						long trnsdate5 = ThreadLocalRandom.current().longs(start5, end5).findAny().getAsLong();
						try {
							Date date5 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate5)));
							bw.append(format2.format(date5));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");

						LocalDate startDate6 = LocalDate.of(2015, 1, 1); // start
						// date
						long start6 = startDate6.toEpochDay();
						LocalDate endDate6 = LocalDate.of(2016, 1, 1); // end
						// date
						long end6 = endDate6.toEpochDay();
						long trnsdate6 = ThreadLocalRandom.current().longs(start6, end6).findAny().getAsLong();
						try {
							Date date6 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate6)));
							bw.append(format2.format(date6));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");

						LocalDate startDate7 = LocalDate.of(2015, 1, 1); // start
						// date
						long start7 = startDate6.toEpochDay();
						LocalDate endDate7 = LocalDate.of(2016, 1, 1); // end
						// date
						long end7 = endDate7.toEpochDay();
						long trnsdate7 = ThreadLocalRandom.current().longs(start7, end7).findAny().getAsLong();
						try {
							Date date7 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate7)));
							bw.append(format2.format(date7));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");




						// bank charges type, amt, date

						bw.append(String.valueOf(bnkchrgtyp[random.nextInt(bnkchrgtyp.length)]));
						bw.append(",");

						int bnkamt = random.nextInt(1000);
						bw.append(String.valueOf(bnkamt));
						bw.append(",");

						LocalDate startDate8 = LocalDate.of(2015, 1, 1); // start
																			// date
						long start8 = startDate8.toEpochDay();
						LocalDate endDate8 = LocalDate.of(2016, 1, 1); // end
																		// date
						long end8 = endDate8.toEpochDay();
						long trnsdate8 = ThreadLocalRandom.current().longs(start8, end8).findAny().getAsLong();
						try {
							Date date8 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate8)));
							bw.append(format2.format(date8));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");


// complain date, category, branch code

						LocalDate startDate9 = LocalDate.of(2015, 1, 1); // start
						// date
						long start9 = startDate9.toEpochDay();
						LocalDate endDate9 = LocalDate.of(2016, 1, 1); // end
						// date
						long end9 = endDate9.toEpochDay();
						long trnsdate9 = ThreadLocalRandom.current().longs(start9, end9).findAny().getAsLong();
						try {
							Date date9 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate9)));
							bw.append(format2.format(date9));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");

						bw.append(String.valueOf(cmplnctgry[random.nextInt(cmplnctgry.length)]));
						bw.append(",");

						long brchcode = random.nextInt(10000000);
						bw.append(String.valueOf(brchcode));
						bw.append(",");



						
						// age
						bw.append(String.valueOf(age));
						bw.append(",");

						// gender
						bw.append(String.valueOf(gender[gnint]));
						bw.append(",");


// request logged date

						LocalDate startDate10 = LocalDate.of(2015, 1, 1); // start
						// date
						long start10 = startDate10.toEpochDay();
						LocalDate endDate10 = LocalDate.of(2016, 1, 1); // end
						// date
						long end10 = endDate10.toEpochDay();
						long trnsdate10 = ThreadLocalRandom.current().longs(start10, end10).findAny().getAsLong();
						try {
							Date date10 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate10)));
							bw.append(format2.format(date10));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");


// query logged date

						LocalDate startDate11 = LocalDate.of(2015, 1, 1); // start
						// date
						long start11 = startDate11.toEpochDay();
						LocalDate endDate11 = LocalDate.of(2016, 1, 1); // end
						// date
						long end11 = endDate11.toEpochDay();
						long trnsdate11 = ThreadLocalRandom.current().longs(start11, end11).findAny().getAsLong();
						try {
							Date date11 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate11)));
							bw.append(format2.format(date11));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

						bw.append(",");
     // cheque bounce yes/no and date
     String cheqbnc=String.valueOf(chqbnc[random.nextInt(chqbnc.length)]);
						bw.append(cheqbnc);

						bw.append(",");
						LocalDate startDate12 = LocalDate.of(2015, 1, 1); // start
						// date
						long start12 = startDate12.toEpochDay();
						LocalDate endDate12 = LocalDate.of(2016, 1, 1); // end
						// date
						long end12 = endDate12.toEpochDay();
						long trnsdate12 = ThreadLocalRandom.current().longs(start12, end12).findAny().getAsLong();
						try {
							Date date12 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate12)));
							bw.append(format2.format(date12));
						} catch (Exception e) {
							System.out.println("exception caught");
						}

				bw.append("\n");

			}

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}
