import pytest

@pytest.fixture
def num_list():
    # can use a variable as well and list int he valuses, which ever works
    return list(range(11))


@pytest.fixture
def wallet():
    amount=0
    return amount