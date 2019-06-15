package DemoProj;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ClassificationData 
{
	// private static final String FILENAME = "/home/nt/filename.txt";
		private static final String FILENAME = "/home/nt/Desktop/a.csv";

		public static void main(String[] args) {

			String fileName = args[0];
			long randomNumber = Long.parseLong(args[1]);
			long numberOfRows = Long.parseLong(args[2]);

			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				fw = new FileWriter(fileName);
				bw = new BufferedWriter(fw);
				String firstRow = "UCIC_ID,NO_OF_Accs,Target_col,vintage,EMAIL_UNSUBSCRIBE,OCCUP_ALL_NEW,city,dependents,zip,Balance_Amount,Transaction_Amount,Transaction_Type,Transaction_Channel,Transaction_Date,Product_Purchase,Product_Purchase_Date,Product_Amt,NEFT_TO_Beneficiary,NEFT_Amt,BilllPayRegisterDate,BilllPaymentDone,BillPaymentAmount,LOAN_Product_Type,LOAN_EMI_Transaction_Amount,LOAN_EMI_Transaction_Date,Product_LOAN_Maturity_Date,Product_Loan_Disbursal_Date,Bank_Charges_Type,Bank_Charges_Amount,Bank_Charges_Date,Complain_Date,Complain_Category,brn_code,age,Gender,Request_Logged_Date,Query_Logged_Date,CHeque_Bounce,Cheque_Bounce_Date\n";
				bw.write(firstRow);

				Random random = new Random(randomNumber);

				// random userid
				int ucLow = 1;
				// int ucHigh = 1000;
				int ucic = 0;
				// no of access btwn 1 and 20
				int accLow = 1;
				int accHigh = 20;
				int accs;
				// hnw ctgry

				String[] Target = { "1", "0" };
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
					// ucic = random.nextInt(1000);
					// ucic = random.nextInt(ucHigh - ucLow) + ucLow;
					StringBuffer currentRow = new StringBuffer("");
					ucic++;
					currentRow.append(String.valueOf(ucic));
					currentRow.append(",");

					accs = random.nextInt(accHigh - accLow) + accLow;
					currentRow.append(String.valueOf(accs)+",");

					int hnwint = random.nextInt(Target.length);
					currentRow.append(String.valueOf(Target[hnwint])+",");

					int vint = random.nextInt(vintage.length);
					currentRow.append(String.valueOf(vintage[vint]));
					currentRow.append(",");

					int eint = random.nextInt(email.length);
					currentRow.append(String.valueOf(email[eint]));
					currentRow.append(",");

					int oint = random.nextInt(occupation.length);
					currentRow.append(String.valueOf(occupation[oint]));
					currentRow.append(",");

					int cint = random.nextInt(city.length);
					currentRow.append(String.valueOf(city[cint]));
					currentRow.append(",");

					int dpndint = random.nextInt(dpHigh - dpLow) + dpLow;
					currentRow.append(String.valueOf(dpndint));
					currentRow.append(",");

					zip = random.nextInt(10000000);
					currentRow.append(String.valueOf(zip));
					currentRow.append(",");
					// age
					int ageLow = 18;
					int ageHigh = 100;
					int age = random.nextInt(ageHigh - ageLow) + ageLow;
					// gender
					int gnint = random.nextInt(gender.length);

					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
					SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yyyy");

					int balnc = random.nextInt(1000000);
					currentRow.append(String.valueOf(balnc));
					currentRow.append(",");
					currentRow.append(String.valueOf(random.nextInt(10000)));
					currentRow.append(",");
					currentRow.append(String.valueOf(trnstype[random.nextInt(trnstype.length)]));
					currentRow.append(",");
					currentRow.append(String.valueOf(trnschnl[random.nextInt(trnschnl.length)]));
					currentRow.append(",");

					LocalDate startDate1 = LocalDate.of(2015, 1, 1); // start
																		// date
					long start1 = startDate1.toEpochDay();
					LocalDate endDate1 = LocalDate.of(2016, 1, 1); // end
																	// date
					long end1 = endDate1.toEpochDay();
					long trnsdate1 = ThreadLocalRandom.current().longs(start1, end1).findAny().getAsLong();
					try {
						Date date1 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate1)));
						currentRow.append(format2.format(date1));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

	// product details

					currentRow.append(String.valueOf(prdctprchs[random.nextInt(prdctprchs.length)]));
					currentRow.append(",");

					LocalDate startDate2 = LocalDate.of(2015, 1, 1); // start
																		// date
					long start2 = startDate2.toEpochDay();
					LocalDate endDate2 = LocalDate.of(2016, 1, 1); // end
																	// date
					long end2 = endDate2.toEpochDay();
					long trnsdate2 = ThreadLocalRandom.current().longs(start2, end2).findAny().getAsLong();
					try {
						Date date2 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate2)));
						currentRow.append(format2.format(date2));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

					int pramt = random.nextInt(100000);
					currentRow.append(String.valueOf(pramt));
					currentRow.append(",");

	// neft amt and date
					int neftamt = random.nextInt(10000);
					currentRow.append(String.valueOf(neftamt));
					currentRow.append(",");

					LocalDate startDate3 = LocalDate.of(2015, 1, 1); // start
																		// date
					long start3 = startDate3.toEpochDay();
					LocalDate endDate3 = LocalDate.of(2016, 1, 1); // end
																	// date
					long end3 = endDate3.toEpochDay();
					long trnsdate3 = ThreadLocalRandom.current().longs(start3, end3).findAny().getAsLong();
					try {
						Date date3 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate3)));
						currentRow.append(format2.format(date3));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

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
						currentRow.append(format2.format(date4));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

					currentRow.append(String.valueOf(bilpay[random.nextInt(bilpay.length)]));
					currentRow.append(",");

					int bilamt = random.nextInt(10000);
					currentRow.append(String.valueOf(bilamt));
					currentRow.append(",");

					// loan details type, emiamt, emi date, maturity date,
					// disburs date

					currentRow.append(String.valueOf(loantyp[random.nextInt(loantyp.length)]));
					currentRow.append(",");

					int emiamt = random.nextInt(10000);
					currentRow.append(String.valueOf(emiamt));
					currentRow.append(",");

					LocalDate startDate5 = LocalDate.of(2015, 1, 1); // start
																		// date
					long start5 = startDate5.toEpochDay();
					LocalDate endDate5 = LocalDate.of(2016, 1, 1); // end
																	// date
					long end5 = endDate5.toEpochDay();
					long trnsdate5 = ThreadLocalRandom.current().longs(start5, end5).findAny().getAsLong();
					try {
						Date date5 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate5)));
						currentRow.append(format2.format(date5));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

					LocalDate startDate6 = LocalDate.of(2015, 1, 1); // start
					// date
					long start6 = startDate6.toEpochDay();
					LocalDate endDate6 = LocalDate.of(2016, 1, 1); // end
					// date
					long end6 = endDate6.toEpochDay();
					long trnsdate6 = ThreadLocalRandom.current().longs(start6, end6).findAny().getAsLong();
					try {
						Date date6 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate6)));
						currentRow.append(format2.format(date6));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

					LocalDate startDate7 = LocalDate.of(2015, 1, 1); // start
					// date
					long start7 = startDate6.toEpochDay();
					LocalDate endDate7 = LocalDate.of(2016, 1, 1); // end
					// date
					long end7 = endDate7.toEpochDay();
					long trnsdate7 = ThreadLocalRandom.current().longs(start7, end7).findAny().getAsLong();
					try {
						Date date7 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate7)));
						currentRow.append(format2.format(date7));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

					// bank charges type, amt, date

					currentRow.append(String.valueOf(bnkchrgtyp[random.nextInt(bnkchrgtyp.length)]));
					currentRow.append(",");

					int bnkamt = random.nextInt(1000);
					currentRow.append(String.valueOf(bnkamt));
					currentRow.append(",");

					LocalDate startDate8 = LocalDate.of(2015, 1, 1); // start
																		// date
					long start8 = startDate8.toEpochDay();
					LocalDate endDate8 = LocalDate.of(2016, 1, 1); // end
																	// date
					long end8 = endDate8.toEpochDay();
					long trnsdate8 = ThreadLocalRandom.current().longs(start8, end8).findAny().getAsLong();
					try {
						Date date8 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate8)));
						currentRow.append(format2.format(date8));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

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
						currentRow.append(format2.format(date9));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

					currentRow.append(String.valueOf(cmplnctgry[random.nextInt(cmplnctgry.length)]));
					currentRow.append(",");

					long brchcode = random.nextInt(10000000);
					currentRow.append(String.valueOf(brchcode));
					currentRow.append(",");

					// age
					currentRow.append(String.valueOf(age));
					currentRow.append(",");

					// gender
					currentRow.append(String.valueOf(gender[gnint]));
					currentRow.append(",");

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
						currentRow.append(format2.format(date10));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");

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
						currentRow.append(format2.format(date11));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append(",");
					// cheque bounce yes/no and date
					String cheqbnc = String.valueOf(chqbnc[random.nextInt(chqbnc.length)]);
					currentRow.append(cheqbnc);

					currentRow.append(",");
					LocalDate startDate12 = LocalDate.of(2015, 1, 1); // start
					// date
					long start12 = startDate12.toEpochDay();
					LocalDate endDate12 = LocalDate.of(2016, 1, 1); // end
					// date
					long end12 = endDate12.toEpochDay();
					long trnsdate12 = ThreadLocalRandom.current().longs(start12, end12).findAny().getAsLong();
					try {
						Date date12 = format1.parse(String.valueOf(LocalDate.ofEpochDay(trnsdate12)));
						currentRow.append(format2.format(date12));
					} catch (Exception e) {
						System.out.println("exception caught");
					}

					currentRow.append("\n");
					bw.write(currentRow.toString());

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
