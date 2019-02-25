package Model.Expressions;

import Model.Utilities.IDictionary;

public interface IExpr {
    int evaluate(IDictionary<String, Integer> dic, IDictionary<Integer, Integer> heap);
}
