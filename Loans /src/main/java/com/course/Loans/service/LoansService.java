package com.course.Loans.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.Loans.dto.LoansDto;
import com.course.Loans.exception.LoanAlreadyExistsException;
import com.course.Loans.exception.ResourceNotFoundException;
import com.course.Loans.mapper.LoansMapper;
import com.course.Loans.model.Loans;
import com.course.Loans.repository.LoansRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoansService {
  private final LoansRepository loansRepository;

  public LoansDto fetchLoanDetails(String mobileNumber, String loadNumber) {
    Optional<Loans> entry = loansRepository.findByMobileNumber(mobileNumber);
    if (!entry.isPresent())
      throw new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber);

    LoansDto loan = new LoansDto();
    LoansMapper.mapToLoansDto(entry.get(), loan);
    return loan;

  }

  public void createLoan(LoansDto loansDto) {
    Optional<Loans> entry = loansRepository.findByMobileNumber(loansDto.getMobileNumber());
    if (entry.isPresent())
      throw new LoanAlreadyExistsException("Loan already exist on this mobile number");
    Loans loan = new Loans();
    LoansMapper.mapToLoans(loansDto, loan);
    loansRepository.save(loan);

  }

  public void updateLoan(LoansDto loansDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateLoan'");
  }

  public void deleteLoan(String mobileNumber, String loadNumber) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteLoan'");
  }

}
