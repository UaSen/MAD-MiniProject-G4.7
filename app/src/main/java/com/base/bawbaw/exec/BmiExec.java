package com.base.bawbaw.exec;

public class BmiExec {

    //attributes for bmi calculator
    private float weight;
    private float height;
    private String breed;
    private String gender;

    //default constructor
    public BmiExec() {
    }

    //overloaded constructor
    public BmiExec(float weight, float height, String breed, String gender) {
        this.weight = weight;
        this.height = height;
        this.breed = breed;
        this.gender = gender;
    }

    //bmi calculating method
    public float calculateBmi(float weight, float height) {

        float bmiC = weight * 10000 / (height * height);

        return bmiC;

    }

    //method for check health range according to breed and gender
    public int healthRange(String breed, String gender, float weight) {

        int rangeDog = 0;

        if (breed.equals("American Staffordshire Terrie")) {

            if (gender.equals("male")) {

                if (weight < 25) {

                    rangeDog = 1;

                } else if (weight > 30) {

                    rangeDog = 2;
                } else {

                    rangeDog = 3;
                }


            } else if (gender.equals("female")) {

                if (weight < 22) {

                    rangeDog = 1;

                } else if (weight > 27) {

                    rangeDog = 2;
                } else {

                    rangeDog = 3;
                }


            } }else if (breed.equals("Australian Shepherd")) {

                if (gender.equals("male")) {

                    if (weight < 25) {

                        rangeDog = 1;

                    } else if (weight > 29) {

                        rangeDog = 2;
                    } else {

                        rangeDog = 3;
                    }


                } else if (gender.equals("female")) {

                    if (weight < 18) {

                        rangeDog = 1;

                    } else if (weight > 25) {

                        rangeDog = 2;
                    } else {

                        rangeDog = 3;
                    }


                }} else if (breed.equals("Australian Cattle Dog")) {

                    if (gender.equals("male")) {

                        if (weight < 25) {

                            rangeDog = 1;

                        } else if (weight > 28) {

                            rangeDog = 2;
                        } else {

                            rangeDog = 3;
                        }


                    } else if (gender.equals("female")) {

                        if (weight < 15) {

                            rangeDog = 1;

                        } else if (weight > 22) {

                            rangeDog = 2;
                        } else {

                            rangeDog = 3;
                        }


                    }} else if (breed.equals("Beagle")) {

                        if (gender.equals("male")) {

                            if (weight < 13) {

                                rangeDog = 1;

                            } else if (weight > 16) {

                                rangeDog = 2;
                            } else {

                                rangeDog = 3;
                            }


                        } else if (gender.equals("female")) {

                            if (weight < 11) {

                                rangeDog = 1;

                            } else if (weight > 13) {

                                rangeDog = 2;
                            } else {

                                rangeDog = 3;
                            }


                        }} else if (breed.equals("Boxer")) {

                            if (gender.equals("male")) {

                                if (weight < 30) {

                                    rangeDog = 1;

                                } else if (weight > 32) {

                                    rangeDog = 2;
                                } else {

                                    rangeDog = 3;
                                }


                            } else if (gender.equals("female")) {

                                if (weight < 25) {

                                    rangeDog = 1;

                                } else if (weight > 27) {

                                    rangeDog = 2;
                                } else {

                                    rangeDog = 3;
                                }


                            }} else if (breed.equals("Bulldog")) {

                                if (gender.equals("male")) {

                                    if (weight < 24) {

                                        rangeDog = 1;

                                    } else if (weight > 25) {

                                        rangeDog = 2;
                                    } else {

                                        rangeDog = 3;
                                    }


                                } else if (gender.equals("female")) {

                                    if (weight < 22) {

                                        rangeDog = 1;

                                    } else if (weight > 23) {

                                        rangeDog = 2;
                                    } else {

                                        rangeDog = 3;
                                    }


                                }} else if (breed.equals("Cavalier King Charles Spaniel")) {

                                    if (gender.equals("male")) {

                                        if (weight < 5) {

                                            rangeDog = 1;

                                        } else if (weight > 9) {

                                            rangeDog = 2;
                                        } else {

                                            rangeDog = 3;
                                        }


                                    } else if (gender.equals("female")) {

                                        if (weight < 5) {

                                            rangeDog = 1;

                                        } else if (weight > 8) {

                                            rangeDog = 2;
                                        } else {

                                            rangeDog = 3;
                                        }


                                    } }else if (breed.equals("Chihuahua")) {

                                        if (gender.equals("male")) {

                                            if (weight < 1.5) {

                                                rangeDog = 1;

                                            } else if (weight > 3) {

                                                rangeDog = 2;
                                            } else {

                                                rangeDog = 3;
                                            }


                                        } else if (gender.equals("female")) {

                                            if (weight < 1.5) {

                                                rangeDog = 1;

                                            } else if (weight > 3) {

                                                rangeDog = 2;
                                            } else {

                                                rangeDog = 3;
                                            }


                                        }} else if (breed.equals("Daschund-miniature")) {

                                            if (gender.equals("male")) {

                                                if (weight < 4) {

                                                    rangeDog = 1;

                                                } else if (weight > 5) {

                                                    rangeDog = 2;
                                                } else {

                                                    rangeDog = 3;
                                                }


                                            } else if (gender.equals("female")) {

                                                if (weight < 4) {

                                                    rangeDog = 1;

                                                } else if (weight > 5) {

                                                    rangeDog = 2;
                                                } else {

                                                    rangeDog = 3;
                                                }


                                            }} else if (breed.equals("Doberman Pinscher")) {

                                                if (gender.equals("male")) {

                                                    if (weight < 34) {

                                                        rangeDog = 1;

                                                    } else if (weight > 41) {

                                                        rangeDog = 2;
                                                    } else {

                                                        rangeDog = 3;
                                                    }


                                                } else if (gender.equals("female")) {

                                                    if (weight < 29.5) {

                                                        rangeDog = 1;

                                                    } else if (weight > 36) {

                                                        rangeDog = 2;
                                                    } else {

                                                        rangeDog = 3;
                                                    }


                                                }} else if (breed.equals("Fox Terrier")) {

                                                    if (gender.equals("male")) {

                                                        if (weight < 7.25) {

                                                            rangeDog = 1;

                                                        } else if (weight > 8.25) {

                                                            rangeDog = 2;
                                                        } else {

                                                            rangeDog = 3;
                                                        }


                                                    } else if (gender.equals("female")) {

                                                        if (weight < 6.75) {

                                                            rangeDog = 1;

                                                        } else if (weight > 8.25) {

                                                            rangeDog = 2;
                                                        } else {

                                                            rangeDog = 3;
                                                        }


                                                    }} else if (breed.equals("German Shepherd")) {

                                                        if (gender.equals("male")) {

                                                            if (weight < 34) {

                                                                rangeDog = 1;

                                                            } else if (weight > 38.5) {

                                                                rangeDog = 2;
                                                            } else {

                                                                rangeDog = 3;
                                                            }


                                                        } else if (gender.equals("female")) {

                                                            if (weight < 27) {

                                                                rangeDog = 1;

                                                            } else if (weight > 32) {

                                                                rangeDog = 2;
                                                            } else {

                                                                rangeDog = 3;
                                                            }


                                                        } }else if (breed.equals("Golden Retrieverd")) {

                                                            if (gender.equals("male")) {

                                                                if (weight < 31.7) {

                                                                    rangeDog = 1;

                                                                } else if (weight > 36.5) {

                                                                    rangeDog = 2;
                                                                } else {

                                                                    rangeDog = 3;
                                                                }


                                                            } else if (gender.equals("female")) {

                                                                if (weight < 27.2) {

                                                                    rangeDog = 1;

                                                                } else if (weight > 31.7) {

                                                                    rangeDog = 2;
                                                                } else {

                                                                    rangeDog = 3;
                                                                }


                                                            }} else if (breed.equals("Jack Russel Terrier")) {

                                                                if (gender.equals("male")) {

                                                                    if (weight < 6) {

                                                                        rangeDog = 1;

                                                                    } else if (weight > 8) {

                                                                        rangeDog = 2;
                                                                    } else {

                                                                        rangeDog = 3;
                                                                    }


                                                                } else if (gender.equals("female")) {

                                                                    if (weight < 5) {

                                                                        rangeDog = 1;

                                                                    } else if (weight > 7) {

                                                                        rangeDog = 2;
                                                                    } else {

                                                                        rangeDog = 3;
                                                                    }


                                                                }} else if (breed.equals("Labrador Retriever")) {

                                                                    if (gender.equals("male")) {

                                                                        if (weight < 29) {

                                                                            rangeDog = 1;

                                                                        } else if (weight > 36) {

                                                                            rangeDog = 2;
                                                                        } else {

                                                                            rangeDog = 3;
                                                                        }


                                                                    } else if (gender.equals("female")) {

                                                                        if (weight < 25) {

                                                                            rangeDog = 1;

                                                                        } else if (weight > 31) {

                                                                            rangeDog = 2;
                                                                        } else {

                                                                            rangeDog = 3;
                                                                        }


                                                                    } }else if (breed.equals("Pug")) {

                                                                        if (gender.equals("male")) {

                                                                            if (weight < 6) {

                                                                                rangeDog = 1;

                                                                            } else if (weight > 9) {

                                                                                rangeDog = 2;
                                                                            } else {

                                                                                rangeDog = 3;
                                                                            }


                                                                        } else if (gender.equals("female")) {

                                                                            if (weight < 6) {

                                                                                rangeDog = 1;

                                                                            } else if (weight > 8) {

                                                                                rangeDog = 2;
                                                                            } else {

                                                                                rangeDog = 3;
                                                                            }


                                                                        }} else if (breed.equals("Rottweiler")) {

                                                                            if (gender.equals("male")) {

                                                                                if (weight < 45) {

                                                                                    rangeDog = 1;

                                                                                } else if (weight > 54) {

                                                                                    rangeDog = 2;
                                                                                } else {

                                                                                    rangeDog = 3;
                                                                                }


                                                                            } else if (gender.equals("female")) {

                                                                                if (weight < 36) {

                                                                                    rangeDog = 1;

                                                                                } else if (weight > 41) {

                                                                                    rangeDog = 2;
                                                                                } else {

                                                                                    rangeDog = 3;
                                                                                }


                                                                            }} else if (breed.equals("Schnauzer- miniature")) {

                                                                                if (gender.equals("male")) {

                                                                                    if (weight < 16) {

                                                                                        rangeDog = 1;

                                                                                    } else if (weight > 23) {

                                                                                        rangeDog = 2;
                                                                                    } else {

                                                                                        rangeDog = 3;
                                                                                    }

                                                                                } else if (gender.equals("female")) {

                                                                                    if (weight < 14) {

                                                                                        rangeDog = 1;

                                                                                    } else if (weight > 20) {

                                                                                        rangeDog = 2;
                                                                                    } else {

                                                                                        rangeDog = 3;
                                                                                    }


                                                                                } }else if (breed.equals("Siberian Husky")) {

                                                                                    if (gender.equals("male")) {

                                                                                        if (weight < 20) {

                                                                                            rangeDog = 1;

                                                                                        } else if (weight > 27) {

                                                                                            rangeDog = 2;
                                                                                        } else {

                                                                                            rangeDog = 3;
                                                                                        }


                                                                                    } else if (gender.equals("female")) {

                                                                                        if (weight < 16) {

                                                                                            rangeDog = 1;

                                                                                        } else if (weight > 23) {

                                                                                            rangeDog = 2;
                                                                                        } else {

                                                                                            rangeDog = 3;
                                                                                        }


                                                                                    }} else if (breed.equals("Whippet")) {

                                                                                        if (gender.equals("male")) {

                                                                                            if (weight < 10) {

                                                                                                rangeDog = 1;

                                                                                            } else if (weight > 13) {

                                                                                                rangeDog = 2;
                                                                                            } else {

                                                                                                rangeDog = 3;
                                                                                            }


                                                                                        } else if (gender.equals("female")) {

                                                                                            if (weight < 8) {

                                                                                                rangeDog = 1;

                                                                                            } else if (weight > 11) {

                                                                                                rangeDog = 2;
                                                                                            } else {

                                                                                                rangeDog = 3;
                                                                                            }


                                                                                        }


                                                                                    }

                                                                                    return rangeDog;

                                                                                }}
