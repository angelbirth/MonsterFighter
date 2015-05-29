package ObjectModel;

import Helper.IAttacking;

public abstract class Monster implements IAttacking {

    private int hp = 0;
    private String _name = "";
    private int _attack = 0;

    public enum SkillType {

        BITE,
        KICK,
        CLAW
    }
    private SkillType _skill;

    protected Monster(String name, int live, int attack, SkillType skill) {
        _name = name;
        hp = live;
        _skill = skill;
        _attack = attack;
    }

    public void setSkill(SkillType skill) {
        _skill = skill;
    }

    public String getSkillName() {
        return _skill.name();
    }

    protected void setHp(int live) {
        hp = live;
    }

    public int getHp() {
        return hp;
    }

    protected void setMonsterName(String name) {
        _name = name;
    }

    public String getMonsterName() {
        return _name;
    }

    public int getAttack(boolean isSkillUsed) {
        if (isSkillUsed) {
            switch (_skill) {
                case BITE:
                    return _attack * 2;
                case KICK:
                    return _attack * 5;
                case CLAW:
                    return _attack * 10;
                default:
                    return _attack;
            }
        }
        return _attack;
    }

    public void setAttack(int attack) {
        _attack = attack;
    }

    protected boolean attackUsingSkill(Monster enemy, boolean isSkillUsed) {

        int live;
        if (isSkillUsed) {
            System.out.println(_name+ " attack using skill " + _skill.name() + "(" + getAttack(true) + ")");
            live = enemy.hp - getAttack(true);
        } else {
            System.out.println(getMonsterName() + " attack (" + getAttack(false) + ")");
            live = enemy.hp - getAttack(false);
        }
        enemy.hp=live;
        if (enemy.getHp() > 0) {
            System.out.println(enemy._name + "(" + enemy.hp + ")");
            return false;
        } else {
            System.out.println(enemy._name + "(DEFEATED)");
            return true;
        }
    }
}
