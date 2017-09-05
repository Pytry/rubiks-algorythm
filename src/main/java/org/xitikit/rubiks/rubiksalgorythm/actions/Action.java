package org.xitikit.rubiks.rubiksalgorythm.actions;

/**
 * Created by Keith on 9/4/2017.
 */
public class Action
{
  private final ActionCode code;
  private final int turns;

  public Action(ActionCode code, int turns)
  {
    this.code = code;
    this.turns = turns;
  }

  public ActionCode getCode()
  {
    return code;
  }

  public int getTurns()
  {
    return turns;
  }
}
