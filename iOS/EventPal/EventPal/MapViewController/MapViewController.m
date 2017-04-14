//
//  ViewController.m
//  EventPal
//
//  Created by Yan Kononov on 29/03/2017.
//  Copyright © 2017 Yanislav Kononov. All rights reserved.
//
#import "Event.h"
#import "MapViewController.h"
#import <Realm/Realm.h>
#import "DatabaseManager.h"
#import <GoogleMaps/GoogleMaps.h>
@interface MapViewController ()
<
UIAlertViewDelegate,
CLLocationManagerDelegate
>
@property (weak, nonatomic) IBOutlet GMSMapView *mapView;
@property(nonatomic, strong) CLLocationManager *locationManager;
@property(nonatomic, strong) CLLocation *userLocation;

@end

@implementation MapViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.locationManager = [[CLLocationManager alloc] init];
    self.locationManager.delegate = self;
    self.locationManager.desiredAccuracy = kCLLocationAccuracyNearestTenMeters; // 10 m
    
    if([UIAlertController class] != nil) //if not iOS7
        [self.locationManager requestWhenInUseAuthorization];
    [self.locationManager startUpdatingLocation];
    
    RLMResults<Event*>* results = [[DatabaseManager sharedInstance] getEvents];
    for (Event* result in results)
    {
        [self addMarkerWithTitle:result.name andDescription:@"" located:result.location];
    }
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)initializeCamera
{
    GMSCameraPosition *camera = [GMSCameraPosition cameraWithLatitude:55.719643
                                                            longitude:37.418620
                                                                 zoom:10];
    self.mapView.myLocationEnabled = YES;
    self.mapView.settings.myLocationButton = YES;
    self.mapView.camera = camera;
    
};

- (void)locationManager:(CLLocationManager *)manager didUpdateLocations:(NSArray *)locations {
    CLLocation* location = [locations lastObject];
    NSDate* eventDate = location.timestamp;
    NSTimeInterval howRecent = [eventDate timeIntervalSinceNow];
    if (fabs(howRecent) < 15.0)
    {
        [self.locationManager stopUpdatingLocation];
        self.userLocation = location;
        [self initializeCamera];
    }
}

-(void) addMarkerWithTitle:(NSString*)title andDescription:(NSString*)description located:(Location*) location
{
    //    [self.mapView clear];
    GMSMarker *marker = [[GMSMarker alloc] init];
    marker.position = [location coordinates];
    marker.title = title;
    marker.snippet = description;
    marker.icon = [GMSMarker markerImageWithColor:[UIColor blackColor]];
    marker.map = self.mapView;
}


- (void)didReceiveMemoryWarning {
    
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)createButtonTapped:(UIButton *)sender {
}


@end
