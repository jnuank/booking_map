package book.application.repository;

import book.domain.model.item.ItemNumber;
import book.domain.model.loan.loan.Loan;
import book.domain.model.loan.loan.LoanRequest;
import book.domain.model.loan.returned.Returned;
import book.domain.model.loan.rule.LoanStatus;
import book.domain.model.member.MemberNumber;

/**
 * 貸出リポジトリ
 */
public interface LoanRepository {

    void loan(LoanRequest loanRequest);

    LoanStatus status(MemberNumber memberNumber);

    Loan findBy(ItemNumber itemNumber);

    void returned(Returned returned);
}
