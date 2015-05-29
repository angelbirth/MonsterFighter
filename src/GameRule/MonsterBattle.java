package GameRule;

import java.util.Random;

import ObjectModel.Monster;
import ObjectModel.Monster.SkillType;
import ObjectModel.WaterMonster;

public class MonsterBattle {
	
	public static void main(String[] args){
	
		WaterMonster shark = new WaterMonster("Sharken", 2500, 100, SkillType.Bite);
		WaterMonster whales = new WaterMonster("Whalesio", 5000, 20, SkillType.Bite);
		startBattle(shark, whales);
	}
	
	private static void startBattle(Monster a, Monster b){
		
		System.out.println(a.getMonsterName() + "(" + a.getLive() +") Versus " + b.getMonsterName() + "(" + b.getLive() + ")");
		System.out.println("+----------------------------------------------+");
		
		boolean result = false;
		int turn = 0;
		Random random = new Random();
	    
		do {
			if (turn == 0){
				result = a.attackingUsingSkill(b, random.nextBoolean());
				turn = 1;
			}else{
				result = b.attackingUsingSkill(a, random.nextBoolean());
				turn = 0;
			}
		} while (!result);
	}
}
