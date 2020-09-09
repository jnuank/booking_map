package book.domain.model.loan.rule;

import book.domain.model.loan.loan.DelayStatus;
import book.domain.model.member.MemberType;

import java.util.HashMap;
import java.util.Map;

import static book.domain.model.loan.loan.DelayStatus.*;
import static book.domain.model.loan.rule.RestrictionOfQuantity.*;
import static book.domain.model.member.MemberType.大人;
import static book.domain.model.member.MemberType.子供;

/**
 * *貸出制限の表条件
 */
class RestrictionMap {

    Map<DelayOfMember, RestrictionOfQuantity> map = new HashMap<>();

    {
        define(遅延日数３日未満, 大人, 貸出５冊まで);
        define(遅延日数３日未満, 子供, 貸出７冊まで);

        define(遅延日数７日未満, 大人, 貸出不可);
        define(遅延日数７日未満, 子供, 貸出４冊まで);

        define(それ以外, 大人, 貸出不可);
        define(それ以外, 子供, 貸出不可);
    }

    void define(DelayStatus delayStatus, MemberType memberType, RestrictionOfQuantity restrictionOfQuantity) {
        map.put(new DelayOfMember(delayStatus, memberType), restrictionOfQuantity);
    }

    RestrictionOfQuantity of(DelayOfMember delayOfMember) {
        return map.get(delayOfMember);
    }
}