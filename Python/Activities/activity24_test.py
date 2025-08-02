import pytest
# Set up the paremeterized test method

@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18), ])
def test_transactions(wallet, earned, spent, expected):
	
    # Add money to your wallet
    wallet += earned
 
    # Subtract amount from wallet
    wallet -= spent
 
    # Assertion
    assert wallet == expected