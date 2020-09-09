package book.application.service.loan;

import book.application.repository.LoanRepository;
import book.domain.model.item.ItemNumber;
import book.domain.model.loan.loan.Loan;
import book.domain.model.loan.rule.LoanStatus;
import book.domain.model.member.MemberNumber;
import org.springframework.stereotype.Service;

/**
 * 貸出参照サービス
 */
@Service
public class LoanQueryService {
    LoanRepository loanRepository;

    LoanQueryService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    /**
     * 会員の貸出を一覧する
     */
    public LoanStatus status(MemberNumber memberNumber) {
        return loanRepository.status(memberNumber);
    }

    /**
     * 貸出を見つける
     */
    public Loan findBy(ItemNumber itemNumber) {
        return loanRepository.findBy(itemNumber);
    }
}