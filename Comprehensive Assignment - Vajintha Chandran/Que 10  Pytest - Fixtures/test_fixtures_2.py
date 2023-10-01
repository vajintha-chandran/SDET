import pytest

@pytest.fixture
def supply_student_details():
    return {
        'name': 'Kirk',
        'course': 'Java',
        'fee': 100
    }

@pytest.fixture
def supply_student_marks():
    return {
        'name': 'Kirk',
        'modile 1': 75,
        'modile 2': 72,
        'modile 1': 87,
        'Total': 234,
        'average': 78
    }

def test_verifyStudentDetails(supply_student_details):
    assert supply_student_details['name'] == 'Kirk'
    assert supply_student_details['course'] == 'Java'
    assert supply_student_details['fee'] == 100


def test_verifyAverageMark(supply_student_marks):
    assert supply_student_marks['name'] == 'Kirk'
    assert supply_student_marks['average'] == (75+72+87)/3

