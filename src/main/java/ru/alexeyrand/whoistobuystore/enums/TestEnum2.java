package ru.alexeyrand.whoistobuystore.enums;

import ru.alexeyrand.whoistobuybase.fsm.ActionWithState;

public enum TestEnum2  {

    AA(TestEnum.A),
    BB(TestEnum.B),
    CC(TestEnum.C);

    TestEnum te;

    TestEnum2(TestEnum te) {
        this.te = te;
    }

    public TestEnum getTe() {
        return te;
    }

    public void setTe(TestEnum te) {
        this.te = te;
    }
}
