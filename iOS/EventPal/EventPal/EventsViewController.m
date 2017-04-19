//
//  EventsViewController.m
//  EventPal
//
//  Created by Yan Kononov on 08/04/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//

#import "EventsViewController.h"
#import "EventTableViewCell.h"
#import "DatabaseManager.h"
#import "EventCreationViewController.h"

@interface EventsViewController ()
<UITableViewDataSource,
 UITableViewDelegate>
@property (weak, nonatomic) IBOutlet UITableView *tableView;
@property (strong, nonatomic) NSMutableArray<Event*> *dataSource;
@property (strong, nonatomic) NSString *nameToGive;
@property (strong, nonatomic) NSString *addressToGive;
@end

@implementation EventsViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    _dataSource = [NSMutableArray array];
    self.tableView.allowsMultipleSelectionDuringEditing = NO;
    RLMResults<Event*>* results = [[DatabaseManager sharedInstance] getEvents];
    for (Event* result in results)
    {
        [_dataSource addObject:result];
    }
    // Do any additional setup after loading the view.
}

-(void)viewWillAppear:(BOOL)animated{
    [_tableView reloadData];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)backButtonTapped:(UIButton *)sender {
    [self dismissViewControllerAnimated:YES completion:nil];
}

-(void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    if ([segue.identifier isEqualToString:@"creation_segue"]) {
        UINavigationController* nv = segue.destinationViewController;
        EventCreationViewController* vc = nv.viewControllers.firstObject;
        vc.name = _nameToGive;
        vc.address = _addressToGive;
    }
}

#pragma mark - UITableViewDataSource

- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        [DatabaseManager deleteInstance:_dataSource[indexPath.row]];
        [_dataSource removeObject:_dataSource[indexPath.row]];
        [_tableView reloadData];
    }
}

-(NSInteger)numberOfSectionsInTableView:(UITableView *)tableView{
    return 1;
}

-(NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section{
    return _dataSource.count;
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    EventTableViewCell* cell = [tableView dequeueReusableCellWithIdentifier:@"EventCell" forIndexPath:indexPath];
    Event* event = _dataSource[indexPath.row];
    [cell setData: event.name andAddress:event.address];
    return cell;
}

-(void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath{
    self.nameToGive = _dataSource[indexPath.row].name;
    self.addressToGive = _dataSource[indexPath.row].address;
    UIStoryboard* storyboard = [UIStoryboard storyboardWithName:@"Main"
                                                         bundle:nil];
    EventCreationViewController *vc =
    [storyboard instantiateViewControllerWithIdentifier:@"creation"];
    
    vc.name = _nameToGive;
    vc.address = _addressToGive;
    vc.event = _dataSource[indexPath.row];
    
    [self presentViewController:vc
                       animated:YES
                     completion:nil];
}

@end
