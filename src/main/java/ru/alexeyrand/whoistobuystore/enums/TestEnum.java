package ru.alexeyrand.whoistobuystore.enums;

import lombok.Setter;
import ru.alexeyrand.whoistobuybase.fsm.StateWithAction;

import java.util.List;
public enum TestEnum  {
    A(TestEnum2.AA), B(TestEnum2.BB), C(TestEnum2.CC);

    TestEnum2 te2;
    TestEnum(TestEnum2 s) {
        this.te2 = s;
    }

    public TestEnum2 getTe2() {
        return te2;
    }

    public void setTe2(TestEnum2 te2) {
        this.te2 = te2;
    }
}
