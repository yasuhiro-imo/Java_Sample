/*
************************************************************
Javaによる統計処理のサンプルコード。

「東大生の身長・体重データ(竹村彰通『統計』共立出版より).pdf」より、
学生５０人分の身長・体重・父親の身長のデータを標本とし、
各項目の平均・分散・共分散を算出し、相関係数を求める。


実行結果として、以下三点が確認できる。
１．学生の身長と体重の間には比較的強い相関関係が存在する（相関係数　0.640）
２．学生の身長と父親の身長の間にはやや弱い相関関係が存在する（相関係数　0.343）
３．学生の体重と父親の身長の間には殆ど相関関係が見られない（相関係数　0.171）
************************************************************
*/

package java_sample;

public class Java_Sample_CalculateCorrelation.java  {

	public static void main(String[] args){
		// 50人分の（身長・体重・父の身長）の配列
		double[] height = {172,176,170,174,170,167,175,179,162,169,184,170,167,165,165,
				175,180,175,163,175,167,172,173,173,165,170,177,181,170,175,
				166,178,170,177,169,185,158,173,177,170,172,180,181,177,173,
				171,168,178,170,171};

		double[] weight = {70,67,70,70,62,50,75,80,60,80,66,55,52,56,64,82,70,75,52,75,
				53,62,69,62,65,70,70,78,56,55,53,72,60,70,68,72,55,60,78,60,
				64,67,80,73,64,57,55,72,56,73};

		double[] paternal_height = {165,150,170,165,163,165,171,156,160,165,178,172,163,163,160,
				176,175,170,170,172,172,173,178,175,160,170,167,170,165,175,
				165,172,166,160,168,172,160,168,160,160,168,175,167,165,164,
				160,160,172,165,180};

		// 平均値（身長・体重・父の身長）mean
		double h_mean = 0, w_mean = 0, p_mean = 0;
		
		for(int i=0; i<height.length; i++) {
			h_mean += height[i] / height.length;
		}
		for(int i=0; i<weight.length; i++) {
			w_mean += weight[i] / weight.length;
		}
		for(int i=0; i<paternal_height.length; i++) {
			p_mean += paternal_height[i] / paternal_height.length;
		}
		// 平均値の表示
		System.out.println(h_mean + "\n" + w_mean + "\n" + p_mean + "\n");

		// 分散の算出 sigma
		double h_sigma = 0, w_sigma = 0, p_sigma = 0;
		
		for(int i=0; i<height.length; i++) {
			h_sigma += Math.pow((height[i] - h_mean), 2);
		}
		h_sigma /= height.length;
		h_sigma = Math.sqrt(h_sigma);
		
		for(int i=0; i<weight.length; i++) {
			w_sigma += Math.pow((weight[i] - w_mean), 2);
		}
		w_sigma /= weight.length;
		w_sigma = Math.sqrt(w_sigma);
		
		for(int i=0; i<paternal_height.length; i++) {
			p_sigma+=Math.pow((paternal_height[i] - p_mean), 2);
		}
		p_sigma /= paternal_height.length;
		p_sigma = Math.sqrt(p_sigma);
		
		// 分散値の表示
		System.out.println(h_sigma + "\n" + w_sigma + "\n" + p_sigma + "\n");

		// 相関係数を計算(身長と体重) Correlation
		// (式) 相関係数 = 共分散 / （標準偏差1 ＊ 標準偏差2） ;
		double total_hw=0;
		
		for(int i=0; i<height.length; i++) {
			total_hw += (height[i] - h_mean) * (weight[i] - w_mean);
		}
		total_hw = total_hw / height.length / h_sigma / w_sigma;

		// 相関係数を計算(身長と父の身長)
		double total_hp = 0;
		
		for(int i=0; i<height.length; i++) {
			total_hp += (height[i] - h_mean) * (paternal_height[i] - p_mean);
		}
		total_hp = total_hp / height.length / h_sigma / p_sigma;

		// 相関係数を計算(体重と父の身長)
		double total_wp=  0;
		
		for(int i=0; i<weight.length; i++) {
			total_wp += (weight[i] - w_mean) * (paternal_height[i] - p_mean);
		}
		total_wp = total_wp / weight.length / w_sigma / p_sigma;

		// 相関係数の結果表示
		System.out.println(total_hw + "\n" + total_hp + "\n" + total_wp + "\n" );
	}
}
