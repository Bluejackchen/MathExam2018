import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathExam2 {
	private int count;
	private int[] numberone;
	private int[] numbertwo;
	private String problem;
	private String answer;
	private int[] sum;
	private int[] flag;
	private BufferedWriter bw;
	private double[] sumgrade2;
	Random random=new Random();//创建一个随机数对象 
	MathExam2(String args,String args1){
		if(args1.equals("1")) 
		{
			question(args);
		}
		else 
		{
			question1(args);
		}
	}
	private void question(String args) {
		count=Integer.parseInt(args);
		sum=new int[count];
		numberone=new int[count];
		numbertwo=new int[count];
		flag=new int[count];
		//实例化这些数组
		File file=new File("out.txt");
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//创建out文件
		try {
			bw=new BufferedWriter(new FileWriter("out.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();//处理异常的方法
		}
		//创建字符缓输出冲流
		for(int i=0;i<count;i++) {
			numberone[i]=random.nextInt(20);
			numbertwo[i]=random.nextInt(20);
			flag[i]=random.nextInt(2);
			if(flag[i]==1) 
			{
				sum[i]=numberone[i]+numbertwo[i]; 
				problem="("+(i+1)+") "+numberone[i]+" + "+numbertwo[i]+" = ";
			}
			else 
			{	for(int j=i;j<=i;) {
				if(numberone[i]>numbertwo[i])
				{
					sum[i]=numberone[i]-numbertwo[i]; 
					problem="("+(i+1)+") "+numberone[i]+" - "+numbertwo[i]+" = ";
				break;
				}
				else 
				{
					numberone[j]=random.nextInt(20);
					numbertwo[j]=random.nextInt(20);
					
				}
			}
			}
			
			try {		
				bw.write(problem);
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(problem);
			}
		//输入解决方案
		System.out.println("------------标准答案---------------");
		try {
			bw.newLine();//换行
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int i=0;i<count;i++) {	
			if(flag[i]==1) 
			{
				answer="("+(i+1)+") "+numberone[i]+" + "+numbertwo[i]+" = "+sum[i];
			}
			else {
				answer="("+(i+1)+") "+numberone[i]+" - "+numbertwo[i]+" = "+sum[i];	
			}
			try {
			
				bw.write(answer);
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(answer);
		}
		System.out.println("211606390 张晋誌 2018年9月11日 13：05");
		//具体的输出解决方案
		try {
			bw.flush();//清空缓冲区
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void question1(String args) {
		count=Integer.parseInt(args);
		sumgrade2=new double[count];
		numberone=new int[count];
		numbertwo=new int[count];
		flag=new int[count];
		//实例化这些数组
		File file=new File("out.txt");
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//创建out文件
		try {
			bw=new BufferedWriter(new FileWriter("out.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();//处理异常的方法
		}
		//创建字符缓输出冲流
		for(int i=0;i<count;i++) {
			numberone[i]=random.nextInt(10);
			numbertwo[i]=random.nextInt(10);
			flag[i]=random.nextInt(2);
			if(flag[i]==1) 
			{
				sumgrade2[i]=numberone[i]*numbertwo[i]; 
				problem="("+(i+1)+") "+numberone[i]+" * "+numbertwo[i]+" = ";
			}
			else 
			{	for(int j=i;j<=i;) {
				if(numbertwo[i]!=0&&numberone[i]%numbertwo[i]==0) //使除数不能为0，且符合小学二年级除法规程 
				{
					sumgrade2[i]=numberone[i]*1.0/numbertwo[i];  //除法用DOUBLE
					problem="("+(i+1)+") "+numberone[i]+" / "+numbertwo[i]+" = ";
					break;
				}
				else 
				{
					numberone[j]=random.nextInt(10);
					numbertwo[j]=random.nextInt(10);
					
				}
			}
			}
			
			try {		
				bw.write(problem);
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(problem);
			}
		//输入解决方案
		System.out.println("------------标准答案---------------");
		try {
			bw.newLine();//换行
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(int i=0;i<count;i++) {
			sum=new int[count];
			sum[i]=(int)sumgrade2[i];
			if(flag[i]==1) 
			{
				answer="("+(i+1)+") "+numberone[i]+" * "+numbertwo[i]+" = "+sum[i];
			}
			else {
				answer="("+(i+1)+") "+numberone[i]+" / "+numbertwo[i]+" = "+sum[i];	
			}
			try {
			
				bw.write(answer);
				bw.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(answer);
		}
		System.out.println("211606390 张晋誌 2018年9月11日");
		//具体的输出解决方案
		try {
			bw.flush();//清空缓冲区
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean isDigit(String args) {
		Pattern pattern=Pattern.compile("[0-9]{1,}");
		Matcher matcher=pattern.matcher((CharSequence) args);
		return matcher.matches();
	}
	//判断字符串是否为一个数字
	public static void main(String[] args) {
		if(isDigit(args[0])&&isDigit(args[1])) 
		{
			if(args.length==2) //判断命令行接收参数的个数
			{
				if(Integer.parseInt(args[0])>0&&(Integer.parseInt(args[1])==1||Integer.parseInt(args[1])==2))
					//判断命令行接收的参数是非负的整数,且第二个参数只能是1或2
				{
					new MathExam2(args[0],args[1]);
				}
				else 
				{
					System.out.println("输入错误,请重新输入");//输入错误后的处理
				}
			}
			else 
			{
				System.out.println("输入错误,请重新输入");
			}
		}
		else 
		{
			System.out.println("输入错误,请重新输入");
		}
	}
}

