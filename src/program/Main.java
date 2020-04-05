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
			if (records[i].name.contains(new String("��ֵ")))
				recharge += records[i].cost;
			else if (records[i].name.contains(new String("��԰")) || records[i].name.contains(new String("ʳ��"))
					|| records[i].name.contains(new String("�̹�"))||records[i].name.contains(new String("����")))
				food += records[i].cost;
			else if (records[i].name.contains(new String("��ˮ")))
				water += records[i].cost;
			else if (records[i].name.contains(new String("ԡ")))
				shower += records[i].cost;
			else
				others += records[i].cost;
		}
		
		System.out.println("��ֵ��"+recharge);
		System.out.println("�Ͳͣ�"+food);
		System.out.println("��ˮ��"+water);
		System.out.println("ϴ�裺"+shower);
		System.out.println("������"+others);

	}

}
