package program;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		BufferedReader buf = null;
		ArrayList<String> iterms = new ArrayList<String>();

		try {
			fr = new FileReader("D:\\Cost.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buf = new BufferedReader(fr);

		for (int i = 0;; i++) {
			String temp = "";
			try {
				temp = buf.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (temp == null) {

				break;
			}

			iterms.add(temp);

		}

		int amount = iterms.size() / 3;

		Record[] records = new Record[amount];

		for (int i = 0; i < amount; i++) {

			String name = iterms.get(3 * i);
			Double cost = Double.parseDouble(iterms.get(3 * i + 1));
			String time = iterms.get(3 * i + 2);

			records[i] = new Record(name, cost, time);

		}
		double recharge = 0;
		double food = 0;
		double shower = 0;
		double water = 0;
		double others = 0;

		for (int i = 0; i < amount; i++) {
			if (records[i].name.contains(new String("充值")))
				recharge += records[i].cost;
			else if (records[i].name.contains(new String("晨园")) || records[i].name.contains(new String("食堂"))
					|| records[i].name.contains(new String("教工"))||records[i].name.contains(new String("餐厅")))
				food += records[i].cost;
			else if (records[i].name.contains(new String("开水")))
				water += records[i].cost;
			else if (records[i].name.contains(new String("浴")))
				shower += records[i].cost;
			else
				others += records[i].cost;
		}
		
		System.out.println("充值："+recharge);
		System.out.println("就餐："+food);
		System.out.println("打水："+water);
		System.out.println("洗澡："+shower);
		System.out.println("其他："+others);

	}

}
