package book.application.service.returns;

import book.application.repository.LoanRepository;
import book.domain.model.loan.returned.Returned;
import org.springframework.stereotype.Service;

/**
 * 返却登録サービス
 */
@Service
public class ReturnBookRecordService {
    LoanRepository loanRepository;

    ReturnBookRecordService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    /**
     * 返却を記録する
     */
    public void returned(Returned returned) {
        loanRepository.returned(returned);
    }
}
