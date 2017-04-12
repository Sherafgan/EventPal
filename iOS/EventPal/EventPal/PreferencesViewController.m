//
//  PreferencesViewController.m
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "PreferencesViewController.h"

@interface PreferencesViewController ()
    @property (weak, nonatomic) IBOutlet UIButton *partyButton;
    @property (weak, nonatomic) IBOutlet UIButton *foodButton;
    @property (weak, nonatomic) IBOutlet UIButton *DanceButton;
    @property (weak, nonatomic) IBOutlet UIButton *Science;
    @property (weak, nonatomic) IBOutlet UIButton *FunButton;
    @property (weak, nonatomic) IBOutlet UIButton *ConferenceButton;
    @property(nonatomic) NSInteger howMuchChosen;
@end

@implementation PreferencesViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)partyButtonPressed:(UIButton *)sender {
    _partyButton.backgroundColor = [UIColor blackColor];
    _howMuchChosen = _howMuchChosen + 1;
    if(_howMuchChosen == 3){
        [self performSegueWithIdentifier:@"pref_to_map" sender:self];
    }
}
- (IBAction)FoodButtonPressed:(UIButton *)sender {
    _foodButton.backgroundColor = [UIColor blackColor];
    _howMuchChosen = _howMuchChosen + 1;
    if(_howMuchChosen == 3){
        [self performSegueWithIdentifier:@"pref_to_map" sender:self];
    }
}
- (IBAction)danceButtonPressed:(UIButton *)sender {
    _DanceButton.backgroundColor = [UIColor blackColor];
    _howMuchChosen = _howMuchChosen + 1;
    if(_howMuchChosen == 3){
        [self performSegueWithIdentifier:@"pref_to_map" sender:self];
    }
}
- (IBAction)scienceButtonPressed:(UIButton *)sender {
    _Science.backgroundColor = [UIColor blackColor];
    _howMuchChosen = _howMuchChosen + 1;
    if(_howMuchChosen == 3){
        [self performSegueWithIdentifier:@"pref_to_map" sender:self];
    }
}
- (IBAction)funButtonPressed:(UIButton *)sender {
    _FunButton.backgroundColor = [UIColor blackColor];
    _howMuchChosen = _howMuchChosen + 1;
    if(_howMuchChosen == 3){
        [self performSegueWithIdentifier:@"pref_to_map" sender:self];
    }
}
- (IBAction)conferenceButtonPressed:(UIButton *)sender {
    _ConferenceButton.backgroundColor = [UIColor blackColor];
    _howMuchChosen = _howMuchChosen + 1;
    if(_howMuchChosen == 3){
        [self performSegueWithIdentifier:@"pref_to_map" sender:self];
    }
}


@end
