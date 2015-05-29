package ObjectModel;

import Helper.IAttacking;


public abstract class Monster implements IAttacking{
	
	private int _live = 0;
	private String _name = "";
	private int _attack = 0;
	
	public enum SkillType { 
		Bite, 
		Kick, 
		Claw 
	}
	
	private SkillType _skill;

	public void createMonster(String name, int live, int attack, SkillType skill){
		setMonsterName(name);
		setLive(live);
		setSkill(skill);
		setAttack(attack);
	}
	
	public void setSkill(SkillType skill){
		_skill = skill;
	}
	
	public String getSkillName(){
		return _skill.name().toString();
	}
	
	protected void setLive(int live) {
		_live = live;
	}

	public int getLive() {
		return _live;
	}

	protected void setMonsterName(String name) {
		_name = name;
	}

	public String getMonsterName() {
		return _name;
	}

	public int getAttack(boolean isSkillUsed) {
		int attack = _attack;
		if (isSkillUsed){
			switch (_skill) {
			case Bite:
				attack = _attack * 2;
				break;
			case Kick:
				attack = _attack * 5;
				break;
			case Claw:
				attack = _attack * 10;
				break;
			default:
				attack = _attack;
				break;
			}
		}
		return attack;
	}

	public void setAttack(int attack) {
		_attack = attack;
	}

	protected boolean attackUsingSkill(Monster enemyMonster, boolean isSkillUsed) {
		
		int live = enemyMonster.getLive();
		if (isSkillUsed){
			System.out.println(getMonsterName() + " attack using skill " + getSkillName() + "("+getAttack(true)+")");
			live = enemyMonster.getLive() - getAttack(true);
		}else{
			System.out.println(getMonsterName() + " attack ("+getAttack(false)+")");
			live = enemyMonster.getLive() - getAttack(false);
		}
		enemyMonster.setLive(live);
		if (enemyMonster.getLive() > 0){
			System.out.println(enemyMonster.getMonsterName() + "(" + enemyMonster.getLive() +")");
			return false;
		}else {
			System.out.println(enemyMonster.getMonsterName() + "(DEFEATED)");
			return true;
		}
	}
}
