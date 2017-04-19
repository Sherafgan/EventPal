//
//  EventCreationViewController.m
//  EventPal
//
//  Created by Yan Kononov on 08/04/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "EventCreationViewController.h"
#import "Event.h"
#import "DatabaseManager.h"

@interface EventCreationViewController ()
@property (weak, nonatomic) IBOutlet UITextField *nameLabel;
@property (weak, nonatomic) IBOutlet UITextField *addressLabel;
@end

@implementation EventCreationViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.nameLabel.text = _name;
    self.addressLabel.text = _address;
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


-(void)setData:(NSString*) name andAddress:(NSString*)address{
    self.nameLabel.text = name;
    self.addressLabel.text = address;
}
- (IBAction)okPressed:(UIButton *)sender {
    Event* event = [Event createEventNamed:self.nameLabel.text withAddress:_address located:_event.location];
    [DatabaseManager createOrUpdateEvent:event];
    [self dismissViewControllerAnimated:YES completion:nil];
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
