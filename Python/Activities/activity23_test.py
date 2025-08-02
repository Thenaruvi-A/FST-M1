import pytest

@pytest.mark.marking
def test_sim(num_list):
    #create a sum variable
    sum=0
    #calculate
    for num in num_list:
        sum+=num

    # Assert
    assert sum!=55
